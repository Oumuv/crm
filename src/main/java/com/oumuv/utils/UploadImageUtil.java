package com.oumuv.utils;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
/**
 * 图片上传工具类
 * Created by charlin on 2017/9/10.
 */
public class UploadImageUtil {
  private String fileType;
  private Long maxSize;
  private Long width;
  private Long height;
  public UploadImageUtil() { }
  public UploadImageUtil(String fileType, Long maxSize, Long width, Long height) {
    this.fileType = fileType;
    this.maxSize = maxSize;
    this.width = width;
    this.height = height;
  }
  /**
   * 检查上传图像大小
   *
   * @param upload
   * @param uploadFileName
   * @param uploadContentType
   * @return
   */
  public String checkUploadImage(File upload, String uploadFileName, String uploadContentType) {
    try {
      if (fileType != null) {
        String[] fileTypes = fileType.split(",");
        int count = 0;
        for (int i = 0; i < fileTypes.length; i++) {
          if (uploadContentType.equals(fileTypes[i])) {
            count++;
            continue;
          }
        }
        if (count == 0) {
          return "您上传的文件类型不对!";
        }
      }
      BufferedImage bi = ImageIO.read(upload);
      int w = bi.getWidth();
      int h = bi.getHeight();
      if (w > width || h > height) {
        return "上传照片宽度和高度不符合要求";
      }
      if (upload.length() > maxSize) {
        return "上传照片过大";
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
  /**
   * 图片上传
   *
   * @param upload
   * @param uploadFileName
   * @param path
   * @return
   * @throws Exception
   */
  public void uploadImage(File upload, String uploadFileName, String path) throws Exception {
    InputStream is = null;
    OutputStream os = null;
    try {
      is = new FileInputStream(upload);
      File f = new File(path);
      if (!f.exists()) f.mkdirs();
      os = new FileOutputStream(path + "/" + uploadFileName);
      byte buffer[] = new byte[1024];
      int count = 0;
      int flag = 0;
      while ((count = is.read(buffer)) > 0) {
        os.write(buffer, 0, count);
      }
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
      File f = new File(path + "/" + uploadFileName);
      if (f.exists()) {
        f.delete();
      }
    } finally {
      try {
        os.close();
        is.close();
      } catch (IOException ioe) {
      }
    }
  }
  /**
   * 清除文件
   * @param path
   */
  public void clear(String path) {
    File file = new File(path);
    if (file.isFile() && file.exists()) {
      file.delete();
    }
  }
  public String getFileType() {
    return fileType;
  }
  public void setFileType(String fileType) {
    this.fileType = fileType;
  }
  public Long getMaxSize() {
    return maxSize;
  }
  public void setMaxSize(Long maxSize) {
    this.maxSize = maxSize;
  }
  public Long getWidth() {
    return width;
  }
  public void setWidth(Long width) {
    this.width = width;
  }
  public Long getHeight() {
    return height;
  }
  public void setHeight(Long height) {
    this.height = height;
  }
}