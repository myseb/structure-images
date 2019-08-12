/*
 * DPD Deutschland GmbH (c) 2019
 *
 * Author      : sebastian
 * Created     : 12.08.2019
 */

package de.seme.structureimages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class StructurImagesUtil
{
   public static FileTime getCreationTime(File file) throws IOException {
      Path p = Paths.get(file.getAbsolutePath());
      BasicFileAttributes view
          = Files.getFileAttributeView(p, BasicFileAttributeView.class)
                      .readAttributes();
      FileTime fileTime=view.creationTime();
      //  also available view.lastAccessTine and view.lastModifiedTime
      return fileTime;
    }

}
