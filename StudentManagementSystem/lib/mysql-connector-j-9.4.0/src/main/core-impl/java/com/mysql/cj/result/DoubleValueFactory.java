/*
 * Copyright (c) 2015, 2025, Oracle and/or its affiliates.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License, version 2.0, as published by
 * the Free Software Foundation.
 *
 * This program is designed to work with certain software that is licensed under separate terms, as designated in a particular file or component or in
 * included license documentation. The authors of MySQL hereby grant you an additional permission to link the program and your derivative works with the
 * separately licensed software that they have either included with the program or referenced in the documentation.
 *
 * Without limiting anything contained in the foregoing, this file, which is part of MySQL Connector/J, is also subject to the Universal FOSS Exception,
 * version 1.0, a copy of which can be found at http://oss.oracle.com/licenses/universal-foss-exception.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License, version 2.0, for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 */

package com.mysql.cj.result;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;

import com.mysql.cj.Constants;
import com.mysql.cj.Messages;
import com.mysql.cj.conf.PropertySet;
import com.mysql.cj.exceptions.NumberOutOfRange;

/**
 * A {@link ValueFactory} to create {@link Double} instances.
 */
public class DoubleValueFactory extends AbstractNumericValueFactory<Double> {

    public DoubleValueFactory(PropertySet pset) {
        super(pset);
    }

    @Override
    public Double createFromLong(long l) {
        if (this.jdbcCompliantTruncationForReads && (l < -Double.MAX_VALUE || l > Double.MAX_VALUE)) {
            throw new NumberOutOfRange(Messages.getString("ResultSet.NumberOutOfRange", new Object[] { l, getTargetTypeName() }));
        }
        return (double) l;
    }

    @Override
    public Double createFromBigInteger(BigInteger i) {
        if (this.jdbcCompliantTruncationForReads && (new BigDecimal(i).compareTo(Constants.BIG_DECIMAL_MAX_NEGATIVE_DOUBLE_VALUE) < 0
                || new BigDecimal(i).compareTo(Constants.BIG_DECIMAL_MAX_DOUBLE_VALUE) > 0)) {
            throw new NumberOutOfRange(Messages.getString("ResultSet.NumberOutOfRange", new Object[] { i, getTargetTypeName() }));
        }
        return i.doubleValue();
    }

    @Override
    public Double createFromDouble(double d) {
        if (this.jdbcCompliantTruncationForReads && (d < -Double.MAX_VALUE || d > Double.MAX_VALUE)) {
            throw new NumberOutOfRange(Messages.getString("ResultSet.NumberOutOfRange", new Object[] { d, getTargetTypeName() }));
        }
        return d;
    }

    @Override
    public Double createFromBigDecimal(BigDecimal d) {
        if (this.jdbcCompliantTruncationForReads
                && (d.compareTo(Constants.BIG_DECIMAL_MAX_NEGATIVE_DOUBLE_VALUE) < 0 || d.compareTo(Constants.BIG_DECIMAL_MAX_DOUBLE_VALUE) > 0)) {
            throw new NumberOutOfRange(Messages.getString("ResultSet.NumberOutOfRange", new Object[] { d, getTargetTypeName() }));
        }
        return d.doubleValue();
    }

    @Override
    public Double createFromBit(byte[] bytes, int offset, int length) {
        return new BigInteger(ByteBuffer.allocate(length + 1).put((byte) 0).put(bytes, offset, length).array()).doubleValue();
    }

    @Override
    public String getTargetTypeName() {
        return Double.class.getName();
    }

}
