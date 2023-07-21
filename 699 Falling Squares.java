class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> result = new ArrayList<Integer>(n);
        Square[] squares = new Square[n];
        Square head = new Square();

        for (int i = 0; i < n; i++) {
            Square square = new Square(positions[i]), next = head.next;
            int right = 0, left = 0, mid;

            while (next != null) {
                if (square.landsOn(next)) {
                    square.height += next.height;
                    break;
                }
                squares[right++] = next;
                next = next.next;
            }

            next = head;
            while (left < right) {
                mid = (left + right) / 2;

                if (square.height <= squares[mid].height) {
                    next = squares[mid];
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            square.next = next.next;
            next.next = square;

            result.add(head.next.height);
        }

        return result;
    }

    private class Square {
        int left, right, height;
        Square next;

        public Square() {
            height = Integer.MAX_VALUE;
        }

        public Square(int[] pos) {
            left = pos[0];
            right = left + pos[1];
            height = pos[1];
        }

        public boolean landsOn(Square target) {
            if (left <= target.left && right >= target.right) return true;
            if (target.left <= left) return (left < target.right);
            return (target.left < right && right <= target.right);
        }
    }
}
