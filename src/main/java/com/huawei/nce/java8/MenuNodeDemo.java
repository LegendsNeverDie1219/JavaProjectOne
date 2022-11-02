package com.huawei.nce.java8;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/3/13 10:16
 */
public class MenuNodeDemo {

    public static final Gson GSON = new Gson();

    @Test
    public void test() {
        MenuNode menuNodeInfo = getMenuNodeInfo();
        String json = GSON.toJson(menuNodeInfo);
        System.out.println(json);
       // System.out.println(menuNodeInfo);

    }
    public List<MenuNode> getInitMenuNodes() {
        return Arrays.asList(new MenuNode(1, "根节点", 0),
                new MenuNode(2, "子节点1", 1),
                new MenuNode(3, "子节点1.1", 2),
                new MenuNode(4, "子节点1.2", 2),
                new MenuNode(5, "根节点1.3", 2),
                new MenuNode(6, "根节点2", 1),
                new MenuNode(7, "根节点2.1", 6),
                new MenuNode(8, "根节点2.2", 6),
                new MenuNode(9, "根节点2.2.1", 7),
                new MenuNode(10, "根节点2.2.2", 7),
                new MenuNode(11, "根节点3", 1),
                new MenuNode(12, "根节点3.1", 11));
    }

    public MenuNode getMenuNodeInfo() {
        List<MenuNode> menuNodeList = getInitMenuNodes();
        List<MenuNode> rootNodes =
                menuNodeList.stream().filter(node -> node.getParentId() == 0).collect(Collectors.toList());
        MenuNode rootNode = rootNodes.get(0);
        List<MenuNode> childrenNodesInfo = getChildrenNodesInfo(rootNode, menuNodeList);
        rootNode.setChildrenNodeList(childrenNodesInfo);
        return rootNode;
    }

    public List<MenuNode> getChildrenNodesInfo(MenuNode parentNode, List<MenuNode> menuNodeList) {
        // 处理一级子节点
        return menuNodeList.stream().filter(node -> node.getParentId().equals(parentNode.getId()))
                .peek(node -> node.setChildrenNodeList(getChildrenNodesInfo(node, menuNodeList)))
                .collect(Collectors.toList());
    }

    @Setter
    @Getter
    private static class MenuNode {
        private Integer id;
        private String name;
        private Integer parentId;
        private List<MenuNode> childrenNodeList;

        public MenuNode(Integer id, String name, Integer parentId) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
        }

        public MenuNode(Integer id, String name, Integer parentId, List<MenuNode> childrenNodeList) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
            this.childrenNodeList = childrenNodeList;
        }
    }
}
