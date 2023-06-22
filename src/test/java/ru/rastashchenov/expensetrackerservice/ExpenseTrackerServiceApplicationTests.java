package ru.rastashchenov.expensetrackerservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.rastashchenov.expensetrackerservice.domain.dbone.Client;
import ru.rastashchenov.expensetrackerservice.domain.dbone.Limit;
import ru.rastashchenov.expensetrackerservice.domain.dbone.Transaction;
import ru.rastashchenov.expensetrackerservice.domain.dbtwo.Conversion;
import ru.rastashchenov.expensetrackerservice.feign.client.ExchangeRateApiClient;
import ru.rastashchenov.expensetrackerservice.feign.rest.response.EndOfDayPrice;
import ru.rastashchenov.expensetrackerservice.feign.rest.response.ExchangeRate;
import ru.rastashchenov.expensetrackerservice.feign.servise.ExchangeRateService;
import ru.rastashchenov.expensetrackerservice.repository.dbone.ClientRepository;
import ru.rastashchenov.expensetrackerservice.repository.dbone.LimitRepository;
import ru.rastashchenov.expensetrackerservice.repository.dbone.TransactionRepository;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@SpringBootTest
@ActiveProfiles("test")

public class ExpenseTrackerServiceApplicationTests {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private LimitRepository limitRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	//@Autowired
	//private ConversionRepository conversionRepository;

	@Autowired
	private ExchangeRateApiClient exchangeRateApiClient;

	@Autowired
	private ExchangeRateService exchangeRateService;

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
				.setMadeAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong("1602714051")), ZoneId.systemDefault()).toLocalDate())
				.setSymbol("USD/JPY");

		//Assertions.assertNull(conversion.getId());

		//conversionRepository.save(conversion);
		//Assertions.assertNotNull(conversion.getId());

		//Conversion conversion1 = conversionRepository.getLast("USD/JPY");

	}

	@Test
	public void testExchangeRateApiClient() {

		ExchangeRate exchangeRate = exchangeRateApiClient.getExchangerate("USD/JPY", "68ad2abcea024b089a2f0e9167a51585", ZoneId.systemDefault().toString());
		//EndOfDayPrice endOfDayPrice = exchangeRateApiClient.getEndOfDayPrice("USD/JPY", "68ad2abcea024b089a2f0e9167a51585");

	}

	@Test
	public void testExchangeRateService() {
		exchangeRateService.getAndSaveExchangeRates();
	}

	@Test
	void contextLoads() {

	}

	@Test
	void testTimezones() throws ParseException {

		String dateAsString = "2023-06-17 15:17:05+01";
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX");
		OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateAsString, dateTimeFormatter);
		LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();


	}

}
