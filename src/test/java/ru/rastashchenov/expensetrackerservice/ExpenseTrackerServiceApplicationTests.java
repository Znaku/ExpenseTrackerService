package ru.rastashchenov.expensetrackerservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.rastashchenov.expensetrackerservice.domain.dbone.Client;
import ru.rastashchenov.expensetrackerservice.domain.dbone.Limit;
import ru.rastashchenov.expensetrackerservice.domain.dbone.Transaction;
import ru.rastashchenov.expensetrackerservice.domain.dbtwo.Conversion;
import ru.rastashchenov.expensetrackerservice.repository.dbone.ClientRepository;
import ru.rastashchenov.expensetrackerservice.repository.dbone.LimitRepository;
import ru.rastashchenov.expensetrackerservice.repository.dbone.TransactionRepository;
import ru.rastashchenov.expensetrackerservice.repository.dbtwo.ConversionRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@DataJpaTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
public class ExpenseTrackerServiceApplicationTests {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private LimitRepository limitRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private ConversionRepository conversionRepository;

	@Test
	public void setClientRepositoryTest() {

		Client client = new Client();

		client.setBankAccountNumber("1111111111111");

		Assertions.assertNull(client.getId());

		clientRepository.save(client);
		Assertions.assertNotNull(client.getId());
	}

	@Test
	public void setLimitRepository() {

		Limit limit = new Limit();

		limit.setLimitSum(BigDecimal.valueOf(1000))
				.setRemainingMonthLimit(BigDecimal.valueOf(500000))
				.setLimitDateTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong("1602714051")), ZoneId.systemDefault()))
				.setLimitCurrencyShortname("USD")
				.setLimitExpenseCategory("Other")
				.setLimitClient(Long.valueOf(1));

		Assertions.assertNull(limit.getId());

		limitRepository.save(limit);
		Assertions.assertNotNull(limit.getId());
	}
	@Test
	public void setTransactionRepository(){

		Transaction transaction = new Transaction();
		transaction.setAccountFrom("1111111111")
				.setAccountTo("2222222222")
				.setSum(BigDecimal.valueOf(100))
				.setCurrencyShortname("USD")
				.setExpenseCategory("Other")
				.setCreated(LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong("1602714051")), ZoneId.systemDefault()))
				.setTransactionClient(Long.valueOf(1))
				.setTransactionLimit(Long.valueOf(1))
				.setLimitExceeded(false);

		Assertions.assertNull(transaction.getId());

		transactionRepository.save(transaction);
		Assertions.assertNotNull(transaction.getId());
	}

	@Test
	public void setConversionRepository() {

		Conversion conversion = new Conversion();
		conversion.setRate(BigDecimal.valueOf(105.12))
				.setRateOnPreviousClose(BigDecimal.valueOf(100.00))
				.setMadeAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong("1602714051")), ZoneId.systemDefault()))
				.setSymbol("USD/JPY");

		Assertions.assertNull(conversion.getId());

		conversionRepository.save(conversion);
		Assertions.assertNotNull(conversion.getId());

	}
	@Test
	void contextLoads() {
	}

}
