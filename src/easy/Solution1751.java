package easy;

import javafx.geometry.Pos;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution1751 {
    public boolean findHer(String[] maze) {
        int n = maze.length;
        int m = maze[0].length();

        char[][] charMaze = new char[n][];
        for (int i = 0; i < n; i++) {
            charMaze[i] = maze[i].toCharArray();
        }
        int i = 0, j = 0;
        out:
        for (; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (charMaze[i][j] == 'S')
                    break out;
            }
        }
        return search(charMaze, i, j);
    }

    //recursive
//    public boolean search(char[][] maze, int i, int j){
//        if(maze[i][j] == 'T')
//            return true;
//        maze[i][j] = '1';
//
//        //up
//        boolean up = false;
//        if(i-1 >= 0 && (maze[i-1][j] == '.' || maze[i-1][j] == 'T')){
//            up = search(maze, i-1, j);
//        }
//        //down
//        boolean down = false;
//        if(i+1 < maze.length && (maze[i+1][j] == '.' || maze[i+1][j] == 'T')){
//            down = search(maze, i+1, j);
//        }
//        //left
//        boolean left = false;
//        if(j-1 >= 0 && (maze[i][j-1] == '.' || maze[i][j-1] == 'T')){
//            left = search(maze, i, j-1);
//        }
//        //right
//        boolean right = false;
//        if(j+1 < maze[0].length && (maze[i][j+1] == '.' || maze[i][j+1] == 'T')){
//            right = search(maze, i, j+1);
//        }
//        return up||down||left||right;
//    }

    // wide first
//    public boolean search(char[][] maze, int i, int j) {
//        Queue<Position> queue = new LinkedList<>();
//        queue.add(new Position(i, j));
//        while (!queue.isEmpty()) {
//            Position p = queue.poll();
//            if(maze[p.i][p.j] == 'T')
//                return true;
//            maze[p.i][p.j] = '1';
//            //up
//            if (p.i - 1 >= 0 && (maze[p.i - 1][p.j] == '.' || maze[p.i - 1][p.j] == 'T')) {
//                queue.add(new Position(p.i-1, p.j));
//            }
//            //down
//            if (p.i + 1 < maze.length && (maze[p.i + 1][p.j] == '.' || maze[p.i + 1][p.j] == 'T')) {
//                queue.add(new Position(p.i+1, p.j));
//            }
//            //left
//            if (p.j - 1 >= 0 && (maze[p.i][p.j - 1] == '.' || maze[p.i][p.j - 1] == 'T')) {
//                queue.add(new Position(p.i, p.j-1));
//            }
//            //right
//            if (p.j + 1 < maze[0].length && (maze[p.i][p.j + 1] == '.' || maze[p.i][p.j + 1] == 'T')) {
//                queue.add(new Position(p.i, p.j+1));
//            }
//        }
//        return false;
//    }

    // deep first
    public boolean search(char[][] maze, int i, int j) {
        Stack<Position> stack = new Stack<>();
        stack.push(new Position(i, j));
        while (!stack.isEmpty()) {
            Position p = stack.pop();
            if(maze[p.i][p.j] == 'T')
                return true;
            maze[p.i][p.j] = '1';
            //up
            if (p.i - 1 >= 0 && (maze[p.i - 1][p.j] == '.' || maze[p.i - 1][p.j] == 'T')) {
                stack.push(new Position(p.i-1, p.j));
            }
            //down
            if (p.i + 1 < maze.length && (maze[p.i + 1][p.j] == '.' || maze[p.i + 1][p.j] == 'T')) {
                stack.push(new Position(p.i+1, p.j));
            }
            //left
            if (p.j - 1 >= 0 && (maze[p.i][p.j - 1] == '.' || maze[p.i][p.j - 1] == 'T')) {
                stack.push(new Position(p.i, p.j-1));
            }
            //right
            if (p.j + 1 < maze[0].length && (maze[p.i][p.j + 1] == '.' || maze[p.i][p.j + 1] == 'T')) {
                stack.push(new Position(p.i, p.j+1));
            }
        }
        return false;
    }

    class Position {
        int i;
        int j;

        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        String[] maze = new String[1000];
        File file = new File("100.in");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            for(int i=0;i<1000;i++) {
                maze[i] = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Solution1751 solution1751 = new Solution1751();
        System.out.println(solution1751.findHer(maze));
    }
}
