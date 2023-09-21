package com.trendyol.bootcamp.spring.ch05.aspect;

import com.trendyol.bootcamp.spring.ch05.CaptureSystemOutput;
import com.trendyol.bootcamp.spring.ch05.DbExceptionTestConfig;
import com.trendyol.bootcamp.spring.ch05.TestConstants;
import com.trendyol.bootcamp.spring.ch05.aspect.DBExceptionHandlingAspect;
import com.trendyol.bootcamp.spring.ch05.exception.RewardDataAccessException;
import com.trendyol.bootcamp.spring.ch05.repository.account.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { DbExceptionTestConfig.class })
@EnableAutoConfiguration
class DBExceptionHandlingAspectTests {

    @Autowired
    AccountRepository repository;

    @Test
    @CaptureSystemOutput
    void testReportException(CaptureSystemOutput.OutputCapture capture) {

        // The repository.findByCreditCard(..) method below will
        // result in an exception because we are using empty database
        // set by DbExceptionTestConfig configuration class
        // used by @ContextConfiguration annotation above.
        assertThrows(RewardDataAccessException.class, () -> {
            repository.findByCreditCard("1234123412341234");
        });

        // TODO-12: Validate our AOP is working.
        //  DONE!
        // - An error message should now be logged to the console as a warning
        // - Save all your work and run this test - it should pass with a warning
        //   message on the console AND the console output assertion (below)
        //   should succeed.

        if (TestConstants.CHECK_CONSOLE_OUTPUT) {
            assertThat(capture.toString(), containsString(DBExceptionHandlingAspect.EMAIL_FAILURE_MSG));
        }
    }
}