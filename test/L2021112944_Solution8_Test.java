package test;

import org.junit.Test;
import src.Solution8;

import static org.junit.Assert.assertEquals;

/**
 * Package: Solution8Test
 * Discription:
 *
 * @Author: JUSTIN
 * @Create:11/8/2023 - 2:23 PM
 * @Version:
 */
/**
 * Tests for Solution8
 *
 * To facilitate testing Solution8's functionality works properly
 * to find islands in the grid
 *
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class L2021112944_Solution8_Test {

    // 测试用例设计原则：等价类划分
    // 1. 空网格
    // 2. 仅包含水（'0'）的网格
    // 3. 仅包含陆地（'1'）的网格
    // 4. 包含多个岛屿的网格
    @Test
    // 测试空网格的情况
    public void testEmptyGrid() {
        char[][] grid = {};
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(0, result);
    }

    @Test
    // 测试仅包含水的网格的情况
    public void testGridWithOnlyWater() {
        char[][] grid = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'}
        };
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(0, result);
    }

    @Test
    // 测试仅包含陆地的网格的情况
    public void testGridWithOnlyLand() {
        char[][] grid = {
                {'1', '1', '1'},
                {'1', '1', '1'},
                {'1', '1', '1'}
        };
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(1, result);
    }

    @Test
    // 测试包含多个岛屿的网格的情况
    public void testGridWithMultipleIslands() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(3, result);
    }
    // 测试用例设计原则：等价类划分
    // 1. 在边界条件下DFS方法的情况
    // 2. 在正常情况下DFS方法的情况
    // 3. 在特殊情况下DFS方法的情况

    @Test
    // 测试在边界条件下DFS方法的情况
    public void testDFSBoundaryCase() {
        char[][] grid = {
                {'1', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '1'}
        };
        Solution8 solution = new Solution8();
        solution.dfs(grid, 0, 0);
        char[][] expected = {
                {'0', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '1'}
        };
        assertArrayEquals(expected, grid);
    }

    @Test
    // 测试在正常情况下DFS方法的情况
    public void testDFSNormalCase() {
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '1', '0', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '1'}
        };
        Solution8 solution = new Solution8();
        solution.dfs(grid, 2, 2);
        char[][] expected = {
                {'1', '1', '0', '0'},
                {'1', '1', '0', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '0', '1'}
        };
        assertArrayEquals(expected, grid);
    }

    @Test
    // 测试在特殊情况下DFS方法的情况
    public void testDFSSpecialCase() {
        char[][] grid = {
                {'1', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '1'}
        };
        Solution8 solution = new Solution8();
        solution.dfs(grid, 2, 2);
        char[][] expected = {
                {'1', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '0'}
        };
        assertArrayEquals(expected, grid);
    }
}
