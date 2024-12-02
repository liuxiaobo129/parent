package org.example.flowable;

import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;

public class CustomEventListener implements FlowableEventListener {

    @Override
    public void onEvent(FlowableEvent event) {
        System.out.println("Event received: " + event.getType());
    }

    @Override
    public boolean isFailOnException() {
        return false; // 事件处理失败时是否抛出异常
    }

    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
        return false; // 是否响应事务生命周期事件
    }

    @Override
    public String getOnTransaction() {
        return null;
    }


}