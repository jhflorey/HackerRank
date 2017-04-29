package weekly.week6.day3;

/**
 * Created by yuantian on 7/2/14.
 */

/*
Tieu owns a pizza restaurant and he manages it in his own way. While in a normal restaurant, a customer is served by following the first-come, first-served rule, Tieu simply minimizes the average waiting time of his customers. So he gets to decide who is severed first, regardless of how sooner or later a person comes.

Different kinds of pizzas take different amounts of time to cook. Let's say we have three customers who come at time t=0, t=1, & t=2 respectively, and the time needed to cook their pizzas is 3, 9, & 6 respectively. If Tieu applies first-come, first-served rule, then the waiting time of three customers is 3, 11, & 16 respectively. The average waiting time in this case is (3 + 11 + 16) / 3 = 10. This is not an optimized solution. After serving the first customer at time t=3, Tieu can choose to serve the third customer. In that case, the waiting time will be 3, 7, & 17 respectively. Hence the average waiting time is (3 + 7 + 17) / 3 = 9.

Help Tieu achieve the minimum average waiting time. For the sake of simplicity, just find the integer part of the minimum average waiting time.

Input Format

The first line contains an integer N, which is the number of customers.
In the next N lines, the ith line contains two space separated numbers Ti and Li. Ti is the time when ith customer order a pizza, and Li is the time required to cook that pizza.
Output Format

Display the integer part of the minimum average waiting time.
Constraints

1 ≤ N ≤ 105
0 ≤ Ti ≤ 109
1 ≤ Li ≤ 109
Note

The waiting time is calculated as the difference between the time a customer orders pizza (the time at which they enter the shop) and the time she is served.

Cook does not know about the future orders.

Sample Input #00

3
0 3
1 9
2 6
Sample Output #00

9
Sample Input #01

3
0 3
1 9
2 5
Sample Output #01

8
Explanation #01

Let's call the person ordering at time = 0 as A, time = 1 as B and time = 2 as C. By delivering pizza for A, C and B we get the minimum average wait time to be

(3 + 6 + 16)/3 = 25/3 = 8.33
the integer part is 8 and hence the answer.
*/

/***************************************
 assume the cook does not know the future orders
 ****************************************/

import java.util.*;
import java.io.*;

public class MinimumAverageWaitingTime {

    static void go() {
        int n = in.nextInt();
        Customer[] c = new Customer[n];
        for(int i = 0; i < n; i++) {
            c[i] = new Customer(in.nextInt(), in.nextInt());
        }
        Arrays.sort(c, Customer.Order.ByT.ascending());

        PriorityQueue<Customer> q =
                new PriorityQueue<Customer>(n, Customer.Order.ByL.ascending());
        long time = c[0].t;
        int idx = 0;
        while(idx < n && c[idx].t <= time) {
            q.add(c[idx]);
            idx++;
        }

        long wait = 0;
        while(q.size() > 0) {
            Customer next = q.poll();
            time += next.l;
            wait += time - next.t;

            if (idx < n && q.size() == 0 && time < c[idx].t) {
                time = c[idx].t;
            }
            while(idx < n && c[idx].t <= time) {
                q.add(c[idx]);
                idx++;
            }
        }
        out.println(wait / n);
    }

    public static class Customer {
        public Long t, l;
        public Customer(long t1, long l1) {this.t = t1; this.l = l1;}

        public static enum Order implements Comparator<Customer> {
            ByT() {
                public int compare(Customer c1, Customer c2) {
                    return c1.t.compareTo(c2.t);
                }
            },
            ByL() {
                public int compare(Customer c1, Customer c2) {
                    return c1.l.compareTo(c2.l);
                }
            };

            public abstract int compare(Customer c1, Customer c2);

            public Comparator ascending() {
                return this;
            }

            public Comparator descending() {
                return Collections.reverseOrder(this);
            }
        }
    }

    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args) {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        go();

        out.close();
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder sb = new StringBuilder(1024);
            do {
                sb.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return sb.toString();
        }

        public static boolean isSpaceChar(int c) {
            switch (c) {
                case -1:
                case ' ':
                case '\n':
                case '\r':
                case '\t':
                    return true;
                default:
                    return false;
            }
        }
    }
}