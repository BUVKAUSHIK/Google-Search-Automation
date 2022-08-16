package MINI.PROJECT;

public class Main extends GoogleProject {

	public static void main(String[] args) throws InterruptedException {

		GoogleProject GP = new GoogleProject();

		GP.driverSetup();
		GP.printurl();
		GP.searchoptionsdisplayed();
		GP.screenshotoftheoptionsdisplayed();
		GP.enter();
		GP.numberofsearchresults();
		GP.fullpagescreenshotofsearchresultspage();
		GP.CloseBrowser();

	}
}
