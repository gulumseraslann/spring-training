package com.trendyol.bootcamp.spring.ch05.aspect;

import com.trendyol.bootcamp.spring.ch05.CaptureSystemOutput;
import com.trendyol.bootcamp.spring.ch05.SystemTestConfig;
import com.trendyol.bootcamp.spring.ch05.TestConstants;
import com.trendyol.bootcamp.spring.ch05.repository.account.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SystemTestConfig.class})
@EnableAutoConfiguration
class LoggingAspectTests {

    @Autowired
    AccountRepository repository;

    @Test
    @CaptureSystemOutput
    void testLogger(CaptureSystemOutput.OutputCapture capture) {
        repository.findByCreditCard("1234123412341234");

        if (TestConstants.CHECK_CONSOLE_OUTPUT) {
            // AOP VERIFICATION
            // LoggingAspect should have output an INFO message to console
            String consoleOutput = capture.toString();
            assertTrue(consoleOutput.contains("INFO"));
            assertTrue(consoleOutput.contains("com.trendyol.bootcamp.spring.ch05.aspect.LoggingAspect"));
        }
    }
}
