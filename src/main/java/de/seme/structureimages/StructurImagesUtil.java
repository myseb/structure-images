/*
 * DPD Deutschland GmbH (c) 2019
 *
 * Author      : sebastian
 * Created     : 12.08.2019
 */

package de.seme.structureimages;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.tiff.constants.TiffTagConstants;

public class StructurImagesUtil
{
   public static Date getCreationTime( Path file ) throws Exception
   {
      try
      {
         final ImageMetadata metadata = Imaging.getMetadata( file.toFile() );

         if ( metadata instanceof JpegImageMetadata )
         {
            final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
            String test[] = jpegMetadata.getExif().getFieldValue( TiffTagConstants.TIFF_TAG_DATE_TIME );
            return new SimpleDateFormat( "yyyy:MM:dd hh:mm:ss" ).parse( test[0] );

         }
      }
      catch ( ImageReadException imageReadException )
      {
         // no Image
         return null;
      }
      return null;
   }
}
