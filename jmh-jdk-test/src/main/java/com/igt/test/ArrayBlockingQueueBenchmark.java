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

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, batchSize = 10, timeUnit = TimeUnit.MINUTES)
@Fork(1)
@State(Scope.Benchmark)
public class ArrayBlockingQueueBenchmark {

    @Param({"50"})
    private int batchSize;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);
    private Integer item = new Integer(0);

    private Thread consumerThread;

    @Setup(Level.Trial)
    public void setup() {

        consumerThread = new Thread(() -> {
            Integer i;
            try {
                while ((i = queue.take()) != null) {
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumerThread.setDaemon(true);
        consumerThread.start();
    }

    @TearDown
    public void teardown() throws TimeoutException, InterruptedException {
        if (consumerThread != null) {
            consumerThread.interrupt();
        }
    }

    @Benchmark
    public void testOfferAndTake() {
        for (int i = 0; i < batchSize; i++) {
            while (!queue.offer(item)) {
            }
        }
    }
}
