package org.example.core;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.AccessControlList;
import com.obs.services.model.CreateBucketRequest;
import com.obs.services.model.StorageClassEnum;

public class CreateBucketExample {
    public static void main(String[] args) {
        // 1. 配置华为云 OBS 访问密钥
        String endPoint = "obs.cn-east-3.myhuaweicloud.com"; // 请修改为实际区域的 OBS 终端节点
        String accessKey = ""; // 替换为你的 Access Key
        String secretKey = ""; // 替换为你的 Secret Key

        // 2. 创建 OBS 客户端
        ObsClient obsClient = new ObsClient(accessKey, secretKey, endPoint);

        try {
            // 3. 创建 Bucket 请求
            String bucketName = "my-example-bucket1-4444"; // 替换为你的 Bucket 名称

            CreateBucketRequest request = new CreateBucketRequest(bucketName);
            request.setBucketStorageClass(StorageClassEnum.STANDARD); // 设置存储类型（默认 STANDARD）
            request.setLocation("cn-east-3"); // 设置桶的区域（请填写实际区域）
            request.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ); // 设置桶为私有
            // 4. 发送请求创建 Bucket
            obsClient.createBucket(request);

            System.out.println("Bucket 创建成功：" + bucketName);

            // 5. 确保 ACL 已经正确设置（再次显式设置 ACL）
            obsClient.setBucketAcl(bucketName, AccessControlList.REST_CANNED_PUBLIC_READ);
            System.out.println("已设置桶的 ACL 为 '公共读'");

            System.out.println("Bucket 创建成功：" + bucketName);
        } catch (ObsException e) {
            System.out.println("创建 Bucket 失败：" + e.getErrorMessage());
        } finally {
            // 5. 关闭 OBS 客户端
            try {
                obsClient.close();
            } catch (Exception ignored) {}
        }
    }
}