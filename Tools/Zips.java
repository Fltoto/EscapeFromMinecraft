package Tools;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/**
 * Created by wzj on 2016/9/9.
 */
public class Zips
{
  /**
   * 解压到指定目录
   */
  public static void unZipFiles(String zipPath,String descDir)throws IOException
  {
    unZipFiles(new File(zipPath), descDir);
  }
  /**
   * 解压文件到指定目录
   */
  @SuppressWarnings("rawtypes")
  public static void unZipFiles(File zipFile,String descDir)throws IOException
  {
    File pathFile = new File(descDir);
    if(!pathFile.exists())
    {
      pathFile.mkdirs();
    }
    //解决zip文件中有中文目录或者中文文件
    ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));
    for(Enumeration entries = zip.entries(); entries.hasMoreElements();)
    {
      ZipEntry entry = (ZipEntry)entries.nextElement();
      String zipEntryName = entry.getName();
      InputStream in = zip.getInputStream(entry);
      String outPath = (descDir+zipEntryName).replaceAll("\\*", "/");;
      //判断路径是否存在,不存在则创建文件路径
      File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
      if(!file.exists())
      {
        file.mkdirs();
      }
      //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
      if(new File(outPath).isDirectory())
      {
        continue;
      }
      //输出文件路径信息
      System.out.println(outPath);
      OutputStream out = new FileOutputStream(outPath);
      byte[] buf1 = new byte[1024];
      int len;
      while((len=in.read(buf1))>0)
      {
        out.write(buf1,0,len);
      }
      in.close();
      out.close();
    }
    System.out.println("******************解压完毕********************");
  }
  public static boolean unZip(File zipFile, String descDir) {
      boolean flag = false;
      File pathFile = new File(descDir);
      if (!pathFile.exists()) {
          pathFile.mkdirs();
      }
      ZipFile zip = null;
      try {
          // 指定编码，否则压缩包里面不能有中文目录
          zip = new ZipFile(zipFile, Charset.forName("gbk"));
          for (Enumeration entries = zip.entries(); entries.hasMoreElements();) {
              ZipEntry entry = (ZipEntry) entries.nextElement();
              String zipEntryName = entry.getName();
              InputStream in = zip.getInputStream(entry);
              String outPath = (descDir + zipEntryName).replace("/",
                      File.separator);
              // 判断路径是否存在,不存在则创建文件路径
              File file = new File(outPath.substring(0,
                      outPath.lastIndexOf(File.separator)));
              if (!file.exists()) {
                  file.mkdirs();
              }
              // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
              if (new File(outPath).isDirectory()) {
                  continue;
              }

              OutputStream out = new FileOutputStream(outPath);
              byte[] buf1 = new byte[2048];
              int len;
              while ((len = in.read(buf1)) > 0) {
                  out.write(buf1, 0, len);
              }
              in.close();
              out.close();
          }
          flag = true;
          // 必须关闭，否则无法删除该zip文件
          zip.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
      return flag;
  }
}