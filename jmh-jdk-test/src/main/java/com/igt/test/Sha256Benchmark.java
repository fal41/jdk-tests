// ////////////////////////////////////////////////////////////////////////////
//  NGIN Transaction Engine
//
//  This document  set is  the  property  of GTECH Corporation,  West Greenwich,
//  Rhode Island,  and  contains  confidential  and  trade  secret  information.
//  It cannot  be transferred  from the  custody or control  of  GTECH except as
//  authorized  in  writing  by  an  officer  of  GTECH.  Neither  this item nor
//  the information it contains can be used, transferred, reproduced, published,
//  or disclosed,  in  whole  or in part,  directly  or  indirectly,  except  as
//  expressly authorized by an officer of GTECH,  pursuant to written agreement.
//
//  Copyright 2014 GTECH Corporation. All Rights Reserved.
// ////////////////////////////////////////////////////////////////////////////

package com.igt.test;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;


@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 1, batchSize = 10, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, batchSize = 10, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class Sha256Benchmark {

    @Param({"2048"})
    private String bufferSize = "2048";
    private ByteBuffer bb = ByteBuffer.allocate(2048);

    private MessageDigest messageDigest;
    private byte hash[] = new byte[64];

    public Sha256Benchmark() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Setup(Level.Trial)
    public void setup() {
        bb = ByteBuffer.allocate(Integer.parseInt(bufferSize));
    }


    @Benchmark
    public void messegeDigestSha256() {
        messageDigest.update(bb.array());
        messageDigest.digest(hash);
        messageDigest.reset();
    }

}
