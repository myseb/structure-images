package de.seme.structureimages;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StructureImagesApplication implements CommandLineRunner{

   @Autowired
   private StructureImagesHandler structureImagesHandler;
   
   private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
   
	public static void main(String[] args) {
		SpringApplication.run(StructureImagesApplication.class, args);
	}

   @Override
   public void run( String... args ) throws Exception
   {
      structureImagesHandler.structureImages();
      
   }
	
}
