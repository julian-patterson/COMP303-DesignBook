package chapter3;

import java.util.Comparator;

public enum UniversalComparator {
    byIncreasingSize {
        @Override
        public Comparator<Hand> getComparator() {
            return new Comparator<Hand>() {
                @Override
                public int compare(Hand hand1, Hand hand2) {
                    return hand1.size() - hand2.size();
                }
            };
        }
    },
    byDecreasingSize {
        @Override
        public Comparator<Hand> getComparator() {
            return new Comparator<Hand>() {
                @Override
                public int compare(Hand hand1, Hand hand2) {
                    return hand2.size() - hand1.size();
                }
            };
        }
    };

    public abstract Comparator<Hand> getComparator();

    public static Comparator<Hand> getComparator(UniversalComparator type) {
        switch (type) {
            case byDecreasingSize:
                return byDecreasingSize.getComparator();
            case byIncreasingSize:
                return byIncreasingSize.getComparator();
            default:
                throw new IllegalArgumentException();
        }
    }

}
