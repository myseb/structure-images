/*
 * DPD Deutschland GmbH (c) 2019
 *
 * Author      : sebastian
 * Created     : 12.08.2019
 */

package de.seme.structureimages;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StructureImagesHandler
{
   private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
   
   public void structureImages()
   {
      LOGGER.warn( "structureImages" );
   }
}
