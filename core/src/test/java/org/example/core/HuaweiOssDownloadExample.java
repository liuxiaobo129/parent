package org.example.core;
import com.obs.services.ObsClient;
import com.obs.services.model.GetObjectRequest;
import com.obs.services.model.ObsObject;
import java.io.FileOutputStream;
import java.io.IOException;

public class HuaweiOssDownloadExample {
    public static void main(String[] args) {
        String endpoint = "obs.cn-east-3.myhuaweicloud.com"; // 替换为您的OSS地域节点
        String accessKeyId = ""; // 替换为您的AccessKey ID
        String accessKeySecret = ""; // 替换为您的AccessKey Secret
        String bucketName = "huaweiyun1-814d"; // 替换为您的Bucket名称
        String objectName = "Downloads/result.png"; // 上传到OSS后的文件名（包括路径）
        String localFilePath = "/Users/liuxiaobo/Downloads/result.png"; // 本地文件路径

        ObsClient obsClient = new ObsClient(accessKeyId, accessKeySecret, endpoint);
        try {
            GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, objectName);

            // 处理下载响应
            ObsObject obsObject = obsClient.getObject(getObjectRequest);
            try (FileOutputStream fos = new FileOutputStream("local_file_path")) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = obsObject.getObjectContent().read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("文件下载成功!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭客户端连接
//            obsClient.close();
        }
    }
}