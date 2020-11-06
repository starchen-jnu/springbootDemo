package com.star.springbootdemo;

class CoverageSample {

    public boolean testMethod(int a, int b, int c) {
        boolean result = false;
        if (a == 1 && b == 2 || c == 3) {
            result = true;
        }
        return result;
    }
}
