package org.example.core;

import com.obs.services.ObsClient;
import com.obs.services.model.SetBucketAclRequest;
import com.obs.services.model.AccessControlList;

public class SetBucketDefaultAcl {
    public static void main(String[] args) {
        String endPoint = "obs.cn-east-3.myhuaweicloud.com"; // 请修改为实际区域的 OBS 终端节点
        String accessKey = "IWVJYKYWNH"; // 替换为你的 Access Key
        String secretKey = "C2RjpH1cSUSgkm5Rx"; // 替换为你的 Secret Key
        String bucketName = "my-example-bucket1-2222";

        ObsClient obsClient = new ObsClient(accessKey, secretKey, endPoint);

        try {
            // 设置桶的默认 ACL 为 PUBLIC_READ，这样新上传的文件会继承
            SetBucketAclRequest request = new SetBucketAclRequest(bucketName, AccessControlList.REST_CANNED_PUBLIC_READ);
            obsClient.setBucketAcl(request);

            System.out.println("桶的默认对象 ACL 设置为公共读！");
        } catch (Exception e) {
            System.out.println("设置失败：" + e.getMessage());
        } finally {
            try {
                obsClient.close();
            } catch (Exception ignored) {}
        }
    }
}