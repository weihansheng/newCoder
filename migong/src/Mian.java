import java.util.Stack;

public class Mian {
    static  Stack<Position> path=new Stack<>();
    static  boolean isEnd=false;
    static int[][] visited={
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
    };
    static int[][] isExit={
            {1,1,1,1},
            {1,0,0,1},
            {1,0,0,1},
            {1,0,0,1},
            {1,1,1,1}
    };
    static int[][] maze={
            {1,1,1,1},
            {1,0,0,0},
            {1,0,1,1},
            {1,0,1,1},
            {1,0,2,1}
    };
    public static boolean hasPath(int[][] maze, Position start, Position next){
        if(visited[next.x][next.y]==0&&maze[next.x][next.y]==0){
            path.push(next);
            visited[next.x][next.y]=1;
            if (isExit[next.x][next.y]==1) {
                isEnd = true;
            }
            return true;
        }else
        {
            return false;
        }


    }

    public static  void main(String[] args){
        Position start=new Position(4,1);
        path.push(start);
        visited[start.x][start.y]=1;
        while(!path.isEmpty()&&!isEnd){
            Position position=path.peek();
            //上
            if (position.x-1>=0){
                Position next=new Position(position.x-1,position.y);
                if (hasPath(maze,position,next)){
                    continue;
                }

            }
            //右
            if (position.y+1<maze[0].length){
                Position next=new Position(position.x,position.y+1);
                if (hasPath(maze,position,next)){
                    continue;
                }

            }
            //左
            if (position.y-1>=0){
                Position next=new Position(position.x,position.y-1);
                if (hasPath(maze,position,next)){
                    continue;
                }

            }
            //下
            if (position.x+1<maze.length){
                Position next=new Position(position.x+1,position.y);
                if (hasPath(maze,position,next)){
                    continue;
                }

            }
            path.pop();

        }
        if (path.isEmpty())
        {
            System.out.println("NO");
        }else{
            System.out.println("Yes");
            Position p;
            while(!path.isEmpty()) {
                p=path.pop();
                System.out.println("(x:"+p.x+",y:"+p.y+")");
            }

        }

    }
}
