import java.util.PriorityQueue;

public class RobotGrid {
    // Placeholder code for the main implementation class

    public boolean isSafe(int x, int y) {
        //initialise a sum of absolute digits
        int digitSum = 0;
        int safetyLimit = 23;

        int absX =  Math.abs(x);
        int absY =  Math.abs(y);

        //add x digits
        while ( absX > 0 && digitSum < safetyLimit){
            digitSum += (absX%10);
            absX = absX/10;
        }

        //add y digits
        while ( absY > 0 && digitSum < safetyLimit){
            digitSum += (absY%10);
            absY = absY/10;
        }
        
        return digitSum < safetyLimit;
    }

    public int totalSafeSquares() {
        int safeSquares = 0;
        PriorityQueue<Coord> queue = new PriorityQueue<>();
        boolean[][] thousandbythousand = new boolean[1000][1000];


        queue.offer(new Coord(0, 0));

        while (!queue.isEmpty()) {
            safeSquares++;
            Coord curr = queue.poll();
            thousandbythousand[curr.x][curr.y] = true;
            if (!thousandbythousand[curr.x + 1][curr.y] && isSafe(curr.x + 1, curr.y)) {
                queue.offer(new Coord(curr.x + 1, curr.y));
            }
            if ((curr.x - 1 > 0) && !thousandbythousand[curr.x - 1][curr.y] && isSafe(curr.x - 1, curr.y)) {
                queue.offer(new Coord(curr.x - 1, curr.y));
            }
            if (!thousandbythousand[curr.x][curr.y + 1] && isSafe(curr.x, curr.y + 1)) {
                queue.offer(new Coord(curr.x, curr.y + 1));
            }
            if ((curr.y - 1 > 0) && !thousandbythousand[curr.x][curr.y - 1] && isSafe(curr.x, curr.y - 1)) {
                queue.offer(new Coord(curr.x, curr.y - 1));
            }
        }



        System.out.println();
        return safeSquares * 4;
    }

    public int shortestSafeJourney(int a, int b, int x, int y) {
        int traveled = 0;
        PriorityQueue<Coord> queue = new PriorityQueue<>();
        boolean[][] thousandbythousand = new boolean[1000][1000];
        boolean finished = false;

        while (!queue.isEmpty() || !finished) {
            traveled++;
            Coord curr = queue.poll();
            thousandbythousand[curr.x][curr.y] = true;
            if (!thousandbythousand[curr.x + 1][curr.y] && isSafe(curr.x + 1, curr.y)) {
                queue.offer(new Coord(curr.x + 1, curr.y,traveled));
            }
            if ((curr.x - 1 > 0) && !thousandbythousand[curr.x - 1][curr.y] && isSafe(curr.x - 1, curr.y)) {
                queue.offer(new Coord(curr.x - 1, curr.y,traveled));
            }
            if (!thousandbythousand[curr.x][curr.y + 1] && isSafe(curr.x, curr.y + 1)) {
                queue.offer(new Coord(curr.x, curr.y + 1,traveled));
            }
            if ((curr.y - 1 > 0) && !thousandbythousand[curr.x][curr.y - 1] && isSafe(curr.x, curr.y - 1)) {
                queue.offer(new Coord(curr.x, curr.y - 1,traveled));
            }
        }

        return 0;
    }

    class Coord implements Comparable<Coord>{

        final int x;
        final int y;
        final int traveled;

        @Override
        public int compareTo(Coord T){
            if( this.traveled > T.traveled){return 1;}
            else if(this.traveled < T.traveled){return -1;}
            else{return 0;}
        }
        
        public Coord(int x, int y){
            this.x = x;
            this.y = y;
            this.traveled = 0;
        }
        public Coord(int x, int y,int traveled){
            this.x = x;
            this.y = y;
            this.traveled = traveled;
        }
    }

}
