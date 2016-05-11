package FrogTestV2;

import java.util.*;

public class SearchPath {

    public static void main(String[] args) {
        Board board = new Board();
        Queue<Point> queue = new LinkedList<Point>();
        Point parent = new Board.PointBuilder().setX(6).setY(10).build();
        Point star = new Board.PointBuilder().setX(9).setY(8).setStar(true).build();
        Point tree1 = new Board.PointBuilder().setX(8).setY(13).setTree(true).build();
        Point tree2 = new Board.PointBuilder().setX(7).setY(4).setTree(true).build();

        while (null != parent){
            queue.addAll(board.getNextPoints(parent));
            parent = queue.poll();
            if(parent.isStar())
                break;
        }

        int result = 0;
        while (parent != null) {
            result ++;
            parent = parent.getPARENT();
        }
        System.out.println("Всего ходов " + result);
    }

    private static class Point{
        Point PARENT;
        final boolean tree;

        final boolean star;
        final int x, y;

        private Point(Point parent, boolean tree, boolean star, int x, int y) {
            PARENT = parent;
            this.tree = tree;
            this.star = star;
            this.x = x;
            this.y = y;
        }

        public void setPARENT(Point parent) {
            PARENT = parent;
        }

        public Point getPARENT() {
            return PARENT;
        }

        public boolean isTree() {
            return tree;
        }

        public boolean isStar() {
            return star;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    ", star=" + star +
                    ", tree=" + tree +
                    '}';
        }

    }

    private static class Board{

        final static private Point[][] board = new Point[10][16];

        //Point parent = new Board.PointBuilder().setX(6).setY(10).build();
        List<Point> getNextPoints(Point parent){
            List<Point> newList = new ArrayList<Point>(Arrays.asList(
                    new PointBuilder().setPARENT(parent).setX(parent.getX()).setY(parent.getY()+3).build(),
                    new PointBuilder().setPARENT(parent).setX(parent.getX()+1).setY(parent.getY()+2).build(),
                    new PointBuilder().setPARENT(parent).setX(parent.getX()-1).setY(parent.getY()+2).build(),
                    new PointBuilder().setPARENT(parent).setX(parent.getX()+2).setY(parent.getY()+1).build(),
                    new PointBuilder().setPARENT(parent).setX(parent.getX()-2).setY(parent.getY()+1).build()));
            while (newList.remove(null));
            return newList;
        }

        public static Point setPoint(Point point){
            if(!canSetPoint(point))
                return null;
            if(board[point.getX()][point.getY()] == null)
                board[point.getX()][point.getY()] = point;
            else {
                if(board[point.getX()][point.getY()].isStar()) {
                    board[point.getX()][point.getY()].setPARENT(point.getPARENT());
                }
                point = board[point.getX()][point.getY()];
            }

            return point;
        }

        public static boolean canSetPoint(Point point){
            if(point.getX() >= 0 && point.getX() < 10 && point.getY() >= 0 && point.getY() < 16 && !point.isTree())
                return true;
            return false;
        }

        static class PointBuilder{
            Point PARENT;
            boolean tree, star;
            int x, y;

            public PointBuilder setY(int y) {
                this.y = y;
                return this;
            }

            public PointBuilder setX(int x) {
                this.x = x;
                return this;
            }

            public PointBuilder setStar(boolean star) {
                this.star = star;
                return this;
            }

            public PointBuilder setTree(boolean tree) {
                this.tree = tree;
                return this;
            }

            public PointBuilder setPARENT(Point PARENT) {
                this.PARENT = PARENT;
                return this;
            }

            public Point build(){

                if(y > 15) y = y - 16; //

                Point point = new Point(PARENT, tree, star, x, y);
                return setPoint(point);
            }

        }
    }

}
