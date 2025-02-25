package org.example.core;
import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.AccessControlList;
import com.obs.services.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;

public class HuaweiOssUploadExample {
    public static void main(String[] args) throws IOException {
        // 配置信息
        String endpoint = "obs.cn-east-3.myhuaweicloud.com"; // 替换为您的OSS地域节点
        String accessKeyId = "IWVJYKYWNH"; // 替换为您的AccessKey ID
        String accessKeySecret = "C2RjpH1cSUSgkm5RxPgNCzwdogw"; // 替换为您的AccessKey Secret
        String bucketName = "my-example-bucket1-2222"; // 替换为您的Bucket名称
        String objectName = "Downloads/2result.png"; // 上传到OSS后的文件名（包括路径）
        String localFilePath = "/Users/liuxiaobo/Downloads/result.png"; // 本地文件路径

        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(accessKeyId, accessKeySecret, endpoint);

        try {
            // 创建PutObjectRequest对象
            PutObjectRequest request = new PutObjectRequest(bucketName, objectName, new File(localFilePath));
//            request.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ);
            // 上传文件
            obsClient.putObject(request);

            System.out.println("文件上传成功！");
        } catch (ObsException e) {
            // 处理异常
            e.printStackTrace();
            System.out.println("文件上传失败：" + e.getErrorMessage());
        } finally {
            // 关闭ObsClient实例
            if (obsClient != null) {
                obsClient.close();
            }
        }
    }
}