package testlogs.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import testlogs.model.Constants;
import testlogs.model.Log;
import testlogs.model.LogDetail;
import testlogs.model.SignType;

public class Main {

	private static final Function<String, Log> TRANSFORM_TO_LOG = logInFile -> {
		String[] divideElements = logInFile.split(" ");

		if (divideElements.length != 3) {
			throw new IllegalArgumentException("The row's file must contain exactly three elements");
		}

		return new Log(Integer.valueOf(divideElements[0]), Integer.valueOf(divideElements[1]),
				Constants.SIGN_TYPES.get(divideElements[2]));
	};

	private static final Function<Entry<Integer, List<Log>>, LogDetail> TRANSFORM_TO_LOG_DETAIL = log -> {
		if (log.getValue().size() != 2) {
			return new LogDetail(-1, new Log(), new Log());
		}

		Log signIn = null;
		Log signOut = null;

		for (Log logElements : log.getValue()) {
			if (logElements.getSignType().equals(SignType.SIGN_IN)) {
				signIn = logElements;
			} else {
				signOut = logElements;
			}
		}
		
		if(signIn == null || signOut == null){
			throw new IllegalArgumentException("Some log does not contain both the sign in and sign out");
		}

		LogDetail logDetail = new LogDetail(log.getKey(), signIn, signOut);

		return logDetail;
	};

	public static void main(String[] args) {
		List<String> logElementsInFile = Arrays.asList(
				"200 20601 sign-in",
				"201 20501 sign-in", 
				"202 35060 sign-in", 
				"203 35287 sign-in",
				"202 35065 sign-out", 
				"201 20530 sign-out",
				"200 20620 sign-out");

		generateLog(logElementsInFile);
	}

	public static void generateLog(List<String> logElementsInFile) {

		Map<Integer, List<Log>> logs = logElementsInFile.stream().map(TRANSFORM_TO_LOG)
				.collect(Collectors.groupingBy(Log::getId, HashMap::new, Collectors.toCollection(ArrayList::new)));

		List<LogDetail> logDetails = logs.entrySet().stream().map(TRANSFORM_TO_LOG_DETAIL)
				.filter(i -> i.getId() > 0 && i.getDeltaTime() < 20)
				.sorted(Comparator.comparingInt(i -> i.getSingIn().getTime()))
				.collect(Collectors.toList());

		logDetails.forEach(System.out::println);
	}
}
