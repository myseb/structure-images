/*
 * DPD Deutschland GmbH (c) 2019
 *
 * Author      : sebastian
 * Created     : 12.08.2019
 */

package de.seme.structureimages;

import static de.seme.structureimages.StructurImagesUtil.getCreationTime;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StructureImagesHandler
{
   private static final Logger LOGGER = LoggerFactory.getLogger( MethodHandles.lookup().lookupClass() );

   @Value( "${structure-images.source-folder}" )
   private String sourceFolder;
   @Value( "${structure-images.target-parent-folder}" )
   private String targetParentFolder;
   @Value( "${structure-images.move-file:true}" )
   private boolean moveFile;
   @Value( "${structure-images.replace-existing-file:false}" )
   private boolean replaceExistingFile;
   @Value( "${structure-images.target-folder-date-pattern:yyyy_MM_dd}" )
   private String targetFolderDatePattern;

   public void structureImages() throws IOException
   {
      LOGGER.trace( "structureImages" );

      Files.walk( Paths.get( sourceFolder ) )
           .filter( Files::isRegularFile )
           .forEach( ( file ) -> processFile( file ) );
   }

   private void processFile( Path file )
   {
      try
      {
         SimpleDateFormat sdf = new SimpleDateFormat( targetFolderDatePattern );
         Date fileTime = getCreationTime( file );

         if ( null != fileTime )
         {
            Path target = Paths.get( targetParentFolder )
                               .resolve( sdf.format( fileTime ) )
                               .resolve( file.getFileName() );
            Files.createDirectories( target.getParent() );
            if ( moveFile )
            {
               if(Files.notExists( target ))
               {
                  Files.move( file, target );
                  LOGGER.info( "File " + file.getFileName().toString() + " moved to " + target.getParent().toString() );
               }
               else
               {
                  LOGGER.info( "File " + file.toString() + " not moved to (target already existing)" );
               }
            }
            else
            {
               if(Files.notExists( target ))
               {
                  Files.copy( file, target );
                  LOGGER.info( "File " + file.getFileName().toString() + " copied to " + target.getParent().toString() );
               }
               else
               {
                  LOGGER.info( "File " + file.getFileName().toString() + " not copied to (target already existing)" );
               }
            }
         }
         else
         {
            LOGGER.info( "Pass over file " + file.toString()  );
         }
      }
      catch ( Exception exception )
      {
         LOGGER.warn( "Error processing file " + file.toString(), exception );
      }
   }
}
