<html>
<body>
	<h2>Hello World!</h2>

	<h4>
		Message : ${message}
		</h1>

		<h3>Current weather data</h3>
		<table>
			<tr>
				<td>Station-ID</td>
				<td>${weatherStation.stationId}</td>
			</tr>
			<tr>
				<td>Place</td>
				<td>${weatherStation.city}</td>
			</tr>
			<tr>
				<td>Temperature</td>
				<td>${currentWeatherData.temperature}C°</td>
			</tr>
			<tr>
				<td>Windstrength</td>
				<td>${currentWeatherData.windstrength}</td>
			</tr>
		</table>
</body>
</html>