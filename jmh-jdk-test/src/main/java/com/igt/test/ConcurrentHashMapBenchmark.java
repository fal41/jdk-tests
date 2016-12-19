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

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, batchSize = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class ConcurrentHashMapBenchmark {

    private Map<Integer, Integer> map =  new ConcurrentHashMap<>(1000);
    private Random random = new Random();

    @Benchmark
    @Threads(value = 1)
    public void testSingleThread() {
        doMapOperations();
    }

    @Benchmark
    @Threads(value = 2)
    public void testTwoThreads() {
        doMapOperations();
    }


    @Benchmark
    @Threads(value = 4)
    public void testFourThreads() {
        doMapOperations();
    }

    private void doMapOperations() {
        int p = random.nextInt(1000);
        map.put(p, p);
        int k = random.nextInt(1000);
        map.get(k);
        map.remove(random.nextInt(1000));
    }

}
