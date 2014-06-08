package edu.cmu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.mbenning.weather.wunderground.api.domain.WeatherStation;
import de.mbenning.weather.wunderground.impl.services.HttpDataReaderService;
import de.mbenning.weather.wunderground.impl.services.WeatherStationService;

/**
 * @author Celine Patag
 * 
 */
@Controller
@RequestMapping("/")
public class BaseController {

	@Autowired
	private HttpDataReaderService httpDataReaderService;

	@Autowired
	private WeatherStationService weatherStationService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message",
				"Maven Web Project + Spring 3 MVC - welcome()");		

		WeatherStation weatherStation = new WeatherStation("IDORTMUN1");
		weatherStation.setCity("Dortmund (Stadtkrone-Ost)");
		this.httpDataReaderService.setWeatherStation(weatherStation);

		model.put("weatherStation", weatherStation);
		model.put("currentWeatherData",
				this.httpDataReaderService.getCurrentData());
		
		return "index";

	}

	@RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - "
				+ name);
		return "index";

	}

}