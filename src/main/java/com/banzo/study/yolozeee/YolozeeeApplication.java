package com.banzo.study.yolozeee;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.banzo.study.yolozeee.domain.Difficulty;
import com.banzo.study.yolozeee.domain.Region;
import com.banzo.study.yolozeee.service.TourPackageService;
import com.banzo.study.yolozeee.service.TourService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class YolozeeeApplication implements CommandLineRunner{

	@Value("${yolozeee.importfile}")
	private String importFile;

	@Autowired
	private TourPackageService tourPackageService;

	@Autowired
	private TourService tourService;

	public static void main(String[] args) {
		SpringApplication.run(YolozeeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createTourPackages();
        long numOfTourPackages = tourPackageService.total();
        createTours(importFile);
        long numOfTours = tourService.total();
	}

	private void createTourPackages() {
		tourPackageService.creatTourPackage("BC", "Backpack Cal");
        tourPackageService.creatTourPackage("CC", "California Calm");
        tourPackageService.creatTourPackage("CH", "California Hot springs");
        tourPackageService.creatTourPackage("CY", "Cycle California");
        tourPackageService.creatTourPackage("DS", "From Desert to Sea");
        tourPackageService.creatTourPackage("KC", "Kids California");
        tourPackageService.creatTourPackage("NW", "Nature Watch");
        tourPackageService.creatTourPackage("SC", "Snowboard Cali");
        tourPackageService.creatTourPackage("TC", "Taste of California");
	}

	private void createTours(String fileToImport) throws IOException {
		TourFromFile.read(fileToImport).forEach(importedTour ->
            tourService.createTour(importedTour.getTitle(),
                    importedTour.getDescription(),
                    importedTour.getBlurb(),
                    importedTour.getPrice(),
                    importedTour.getLength(),
                    importedTour.getBullets(),
                    importedTour.getKeywords(),
                    importedTour.getPackageType(),
                    importedTour.getDifficulty(),
                    importedTour.getRegion()));
	}

	/**
     * Helper class to import ExploreCalifornia.json
     */
    private static class TourFromFile {
         //fields
		 private String packageType, title, description, blurb, price, length,
				bullets, keywords, difficulty, region;
		//reader
		static List<TourFromFile> read(String fileToImport) throws IOException {
			return new ObjectMapper().setVisibility(FIELD, ANY).
					readValue(new FileInputStream(fileToImport), new TypeReference<List<TourFromFile>>() {});
		}
		protected TourFromFile(){}

		String getPackageType() { return packageType; }

		String getTitle() { return title; }

		String getDescription() { return description; }

		String getBlurb() { return blurb; }

		Integer getPrice() { return Integer.parseInt(price); }

		String getLength() { return length; }

		String getBullets() { return bullets; }

		String getKeywords() { return keywords; }

		Difficulty getDifficulty() { return Difficulty.valueOf(difficulty); }

		Region getRegion() { return Region.findByLabel(region); }
    }

}