/*
  The MIT License (MIT)

  Copyright (c) 2014-2017 Marc de Verdelhan, Ta4j Organization & respective authors (see AUTHORS)

  Permission is hereby granted, free of charge, to any person obtaining a copy of
  this software and associated documentation files (the "Software"), to deal in
  the Software without restriction, including without limitation the rights to
  use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
  the Software, and to permit persons to whom the Software is furnished to do so,
  subject to the following conditions:

  The above copyright notice and this permission notice shall be included in all
  copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.ta4j.core.Num;

import java.util.function.Function;

/**
 * AbstractNum class
 */
public abstract class AbstractNum extends Number implements Num {


    private static final long serialVersionUID = 9161474401436305600L;

    /** Not-a-Number instance */
    public static final Num NaN = new NaN();

    /**{@link Function} to convert a {@link Number} into the extending implementation*/
    private final Function<Number,Num> numberFunction;

    /**
     * Constructor. <P/>
     * @param integerToNum a {@link Function} to convert a {@link Number} into the extending
     *                     Num implementation
     */
    public AbstractNum(Function<Number, Num> integerToNum){
        this.numberFunction = integerToNum;
    }

    /**
     * @return the function of the extending implementation
     */
    @Override
    public Function<Number,Num> getNumFunction(){
        return numberFunction;
    }

    @Override
    abstract public String toString();

    /**
     * Representation of NaN
     */
    static private class NaN implements Num {

        private static final long serialVersionUID = 4066781362441861638L;

        @Override
        public int compareTo(Num o) {
            throw new UnsupportedOperationException("Arithmetical operation not possible with NaN");
        }

        @Override
        public int intValue() {
            throw new UnsupportedOperationException("Arithmetical operation not possible with NaN");
        }

        @Override
        public long longValue() {
            throw new UnsupportedOperationException("Arithmetical operation not possible with NaN");
        }

        @Override
        public float floatValue() {
            return Float.NaN;
        }

        @Override
        public double doubleValue() {
            return Double.NaN;
        }

        @Override
        public Number getDelegate() {
            return null;
        }

        @Override
        public String getName() {
            return toString();
        }

        @Override
        public String toString() {
            return "NaN";
        }

        @Override
        public Num plus(Num augend) {
            return this;
        }

        @Override
        public Num minus(Num subtrahend) {
            return this;
        }

        @Override
        public Num multipliedBy(Num multiplicand) {
            return this;
        }

        @Override
        public Num dividedBy(Num divisor) {
            return this;
        }

        @Override
        public Num remainder(Num divisor) {
            return this;
        }

        @Override
        public Num pow(int n) {
            return this;
        }

        @Override
        public Num abs() {
            return this;
        }

        @Override
        public boolean isZero() {
            return false;
        }

        @Override
        public boolean isPositive() {
            return false;
        }

        @Override
        public boolean isPositiveOrZero() {
            return false;
        }

        @Override
        public boolean isNegative() {
            return false;
        }

        @Override
        public boolean isNegativeOrZero() {
            return false;
        }

        /**
         * NaN.isEqual(NaN) -> true
         * @param other the other value, not null
         * @return flase if both values are not NaN
         */
        @Override
        public boolean isEqual(Num other) {
            if(!(other instanceof AbstractNum)){
                return false;
            } else if(other.equals(NaN)){
                return true;
            }
            return false;
        }

        @Override
        public boolean isGreaterThan(Num other) {
            return false;
        }

        @Override
        public boolean isGreaterThanOrEqual(Num other) {
            return false;
        }

        @Override
        public boolean isLessThan(Num other) {
            return false;
        }

        @Override
        public boolean isLessThanOrEqual(Num other) {
            return false;
        }

        @Override
        public Num min(Num other) {
            return this;
        }

        @Override
        public Num max(Num other) {
            return this;
        }

        @Override
        public Function<Number, Num> getNumFunction() {
            return number -> NaN;
        }

        @Override
        public boolean isNaN() {
            return true;
        }
    }

}