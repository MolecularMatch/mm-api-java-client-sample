import io.swagger.client.ApiException;
import io.swagger.client.api.SearchApi;
import io.swagger.client.api.StaticApi;
import io.swagger.client.model.Drug;
import io.swagger.client.model.Response;
import io.swagger.client.model.StaticResponse;
import io.swagger.client.model.SuggestionResponse;
import io.swagger.client.model.Trial;

import java.util.List;

public class SampleClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String apiKey = "319833b6-f22f-4f37-bf6b-b988c585d009";	//Local dev api key only, please change to whatever your api key is
		
		try {
			SearchApi client = new SearchApi();

			// Test search
			Response response = client
					.Search(apiKey,
							"",
							"[{\"facet\":\"PHRASE\",\"term\":\"egfr NSCLC - Non-small cell lung cancer\"},{\"term\":\"Enrolling\",\"facet\":\"STATUS\",\"zipcode\":\"\"},{\"term\":\"Interventional\",\"facet\":\"TRIALTYPE\",\"zipcode\":\"\"}]",
							new Integer(0), new Integer(10), "");

			List<Trial> trials = response.getTrials();
			if (trials.size() > 0)
				System.out.println("PASS: Search received " + trials.size()
						+ " trials");
			else
				System.out.println("FAIL: Search");

			// Test search trials
			response = client
					.SearchTrials(
							apiKey,
							"",
							"[{\"facet\":\"PHRASE\",\"term\":\"egfr NSCLC - Non-small cell lung cancer\"},{\"term\":\"Enrolling\",\"facet\":\"STATUS\",\"zipcode\":\"\"},{\"term\":\"Interventional\",\"facet\":\"TRIALTYPE\",\"zipcode\":\"\"}]",
							new Integer(0), new Integer(10), "");

			trials = response.getTrials();
			if (trials.size() > 0)
				System.out.println("PASS: Search Trials received "
						+ trials.size() + " trials");
			else
				System.out.println("FAIL: Search Trials");

			// Test search drugs
			response = client
					.SearchDrugs(
							apiKey,
							"",
							"[{\"facet\":\"PHRASE\",\"term\":\"egfr NSCLC - Non-small cell lung cancer\"},{\"term\":\"Enrolling\",\"facet\":\"STATUS\",\"zipcode\":\"\"},{\"term\":\"Interventional\",\"facet\":\"TRIALTYPE\",\"zipcode\":\"\"}]");

			List<Drug> drugs = response.getDrugs();
			if (drugs.size() > 0)
				System.out.println("PASS: Search Drugs received "
						+ drugs.size() + " drugs");
			else
				System.out.println("FAIL: Search Drugs");

			// Test Suggestions
			SuggestionResponse suggestionResponse = client.GetSuggestions(
					apiKey, "lun", "", 0, 10);
			if (suggestionResponse.getTotal() > 0)
				System.out.println("PASS: Get Suggestions");
			else
				System.out.println("FAIL: Get Suggestions");

			// Test Static
			StaticApi staticClient = new StaticApi();

			StaticResponse staticResponse = staticClient.GetCities(apiKey, 0,
					10);
			if (staticResponse.getRows().size() > 0)
				System.out.println("PASS: Get Cities");
			else
				System.out.println("FAIL: Get Cities");

			staticResponse = staticClient.GetCountries(apiKey, 0, 10);
			if (staticResponse.getRows().size() > 0)
				System.out.println("PASS: Get Countries");
			else
				System.out.println("FAIL: Get Countries");

			staticResponse = staticClient.GetECOGs(apiKey);
			if (staticResponse.getRows().size() > 0)
				System.out.println("PASS: Get ECOG");
			else
				System.out.println("FAIL: Get ECOG");

			staticResponse = staticClient.GetGenders(apiKey);
			if (staticResponse.getRows().size() > 0)
				System.out.println("PASS: Get Gender");
			else
				System.out.println("FAIL: Get Gender");

			staticResponse = staticClient.GetPhases(apiKey);
			if (staticResponse.getRows().size() > 0)
				System.out.println("PASS: Get Phase");
			else
				System.out.println("FAIL: Get Phase");

			staticResponse = staticClient.GetStages(apiKey);
			if (staticResponse.getRows().size() > 0)
				System.out.println("PASS: Get Stage");
			else
				System.out.println("FAIL: Get Stage");

			staticResponse = staticClient.GetStates(apiKey, 0, 10);
			if (staticResponse.getRows().size() > 0)
				System.out.println("PASS: Get State");
			else
				System.out.println("FAIL: Get State");

			staticResponse = staticClient.GetStatuses(apiKey);
			if (staticResponse.getRows().size() > 0)
				System.out.println("PASS: Get Status");
			else
				System.out.println("FAIL: Get Status");

			staticResponse = staticClient.GetTrialTypes(apiKey);
			if (staticResponse.getRows().size() > 0)
				System.out.println("PASS: Get trial type");
			else
				System.out.println("FAIL: Get trial type");

		} catch (ApiException e) {
			e.printStackTrace();
		}

	}

}
