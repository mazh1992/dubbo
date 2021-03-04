/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.remoting.zookeeper;

import org.apache.dubbo.common.URL;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Zookeeper 客户端接口
 */
public interface ZookeeperClient {

    /**
     * 创建节点
     * @param path 节点路径
     * @param ephemeral 是否临时节点
     */
    void create(String path, boolean ephemeral);

    /**
     * 删除节点
     * @param path 节点路径
     */
    void delete(String path);

    /**
     * 获取子节点
     * @param path
     * @return
     */
    List<String> getChildren(String path);

    /**
     * 添加 子节点监听
     * @param path 节点路径
     * @param listener 监听器
     * @return 子节点列表
     */
    List<String> addChildListener(String path, ChildListener listener);

    /**
     * @param path:    directory. All of child of path will be listened. 所有的子节点都被监听
     * @param listener
     */
    void addDataListener(String path, DataListener listener);

    /**
     * @param path:    directory. All of child of path will be listened.
     * @param listener
     * @param executor another thread
     */
    void addDataListener(String path, DataListener listener, Executor executor);

    /**
     * 移除 ChildListener
     * @param path
     * @param listener
     */
    void removeDataListener(String path, DataListener listener);

    void removeChildListener(String path, ChildListener listener);

    /**
     * 添加 StateListener
     * @param listener
     */
    void addStateListener(StateListener listener);

    void removeStateListener(StateListener listener);

    boolean isConnected();

    void close();

    URL getUrl();

    void create(String path, String content, boolean ephemeral);

    String getContent(String path);

    boolean checkExists(String path);

}
