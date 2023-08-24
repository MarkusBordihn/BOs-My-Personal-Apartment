/**
 * Copyright 2023 Markus Bordihn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.markusbordihn.mypersonalapartment.config;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

import de.markusbordihn.mypersonalapartment.Constants;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public final class CommonConfig {

  private static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  private CommonConfig() {}

  public static final ForgeConfigSpec commonSpec;
  public static final Config COMMON;

  static {
    com.electronwill.nightconfig.core.Config.setInsertionOrderPreserved(true);
    final Pair<Config, ForgeConfigSpec> specPair =
        new ForgeConfigSpec.Builder().configure(Config::new);
    commonSpec = specPair.getRight();
    COMMON = specPair.getLeft();
    log.info("Registering {} common config ...", Constants.MOD_NAME);
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, commonSpec);
  }

  public static class Config {

    public final ForgeConfigSpec.IntValue apartmentMaxNumberOfApartments;
    public final ForgeConfigSpec.IntValue apartmentBrokerFee;

    public final ForgeConfigSpec.IntValue apartmentsTier1Price;
    public final ForgeConfigSpec.ConfigValue<List<String>> apartmentsTier1;

    public final ForgeConfigSpec.IntValue generalCommandCoolDown;

    public final ForgeConfigSpec.BooleanValue teleportDelayCounterVisible;
    public final ForgeConfigSpec.BooleanValue teleportDelayEnabled;
    public final ForgeConfigSpec.IntValue teleportDelayCounter;

    public final ForgeConfigSpec.BooleanValue receptionDesertEnabled;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionDesertSmallModel;
    public final ForgeConfigSpec.IntValue receptionDesertSmallModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionDesertMediumModel;
    public final ForgeConfigSpec.IntValue receptionDesertMediumModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionDesertLargeModel;
    public final ForgeConfigSpec.IntValue receptionDesertLargeModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionDesertInfoModel;
    public final ForgeConfigSpec.IntValue receptionDesertInfoModelSpawnWeight;

    public final ForgeConfigSpec.BooleanValue receptionPlainsEnabled;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionPlainsSmallModel;
    public final ForgeConfigSpec.IntValue receptionPlainsSmallModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionPlainsMediumModel;
    public final ForgeConfigSpec.IntValue receptionPlainsMediumModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionPlainsLargeModel;
    public final ForgeConfigSpec.IntValue receptionPlainsLargeModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionPlainsInfoModel;
    public final ForgeConfigSpec.IntValue receptionPlainsInfoModelSpawnWeight;

    public final ForgeConfigSpec.BooleanValue receptionSavannaEnabled;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionSavannaSmallModel;
    public final ForgeConfigSpec.IntValue receptionSavannaSmallModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionSavannaMediumModel;
    public final ForgeConfigSpec.IntValue receptionSavannaMediumModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionSavannaLargeModel;
    public final ForgeConfigSpec.IntValue receptionSavannaLargeModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionSavannaInfoModel;
    public final ForgeConfigSpec.IntValue receptionSavannaInfoModelSpawnWeight;

    public final ForgeConfigSpec.BooleanValue receptionSnowyEnabled;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionSnowySmallModel;
    public final ForgeConfigSpec.IntValue receptionSnowySmallModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionSnowyMediumModel;
    public final ForgeConfigSpec.IntValue receptionSnowyMediumModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionSnowyLargeModel;
    public final ForgeConfigSpec.IntValue receptionSnowyLargeModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionSnowyInfoModel;
    public final ForgeConfigSpec.IntValue receptionSnowyInfoModelSpawnWeight;

    public final ForgeConfigSpec.BooleanValue receptionTaigaEnabled;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionTaigaSmallModel;
    public final ForgeConfigSpec.IntValue receptionTaigaSmallModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionTaigaMediumModel;
    public final ForgeConfigSpec.IntValue receptionTaigaMediumModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionTaigaLargeModel;
    public final ForgeConfigSpec.IntValue receptionTaigaLargeModelSpawnWeight;
    public final ForgeConfigSpec.ConfigValue<List<String>> receptionTaigaInfoModel;
    public final ForgeConfigSpec.IntValue receptionTaigaInfoModelSpawnWeight;

    Config(ForgeConfigSpec.Builder builder) {
      builder.comment(Constants.MOD_NAME);

      builder.push("Apartments");
      apartmentMaxNumberOfApartments = builder.comment("Maximum number of apartments per player.")
          .defineInRange("apartmentMaxNumberOfApartments", 1, 1, 5);
      apartmentBrokerFee = builder.comment("Broker fee for apartments. (0 = no fee)")
          .defineInRange("apartmentBrokerFee", 64, 0, 512);
      builder.pop();

      builder.push("Tier 1 - Apartments");
      apartmentsTier1Price = builder.comment("Price for tier 1 apartments.")
          .defineInRange("apartmentsTier1Price", 100, 0, 10000);
      apartmentsTier1 = builder.comment("List of tier 1 apartments structure.")
          .define("apartmentsTier1", List.of(
            "my_personal_apartment:apartment/16x16/tier1/16x16_tier1_oak_apartment",
            "my_personal_apartment:apartment/16x16/tier1/16x16_tier1_spruce_apartment",
            "my_personal_apartment:apartment/16x16/tier1/16x16_tier1_acacia_apartment"
            ));
      builder.pop();

      builder.push("Commands");
      generalCommandCoolDown =
          builder.comment("Delay in seconds before a teleport command could be used again!")
              .defineInRange("generalCommandCoolDown", 30, 1, 300);
      builder.pop();

      builder.push("Teleport");
      teleportDelayEnabled = builder.comment("Enables teleport delay to avoid cheating!")
          .define("teleportDelayEnabled", true);
      teleportDelayCounterVisible =
          builder.comment("Shows/hide the teleport countdown in the user chat.")
              .define("teleportDelayCounterVisible", true);
      teleportDelayCounter =
          builder.comment("Teleport delay in seconds a player needs to stand still to teleport.")
              .defineInRange("teleportDelayCounter", 10, 0, 60);
      builder.pop();

      builder.push("Reception (Desert)");
      receptionDesertEnabled = builder.comment("Enables the desert reception structures.")
          .define("receptionDesertEnabled", true);
      receptionDesertSmallModel = builder.comment("List of small models for the desert reception.")
          .define("receptionDesertSmallModel",
              List.of("my_personal_apartment:reception/dessert/dessert_small_reception_1"));
      receptionDesertSmallModelSpawnWeight =
          builder.comment("Spawn weight for small models for the desert reception. (0 = disabled)")
              .defineInRange("receptionDesertSmallModelSpawnWeight", 2, 1, 100);
      receptionDesertMediumModel =
          builder.comment("List of medium models for the desert reception.").define(
              "receptionDesertMediumModel",
              List.of("my_personal_apartment:reception/dessert/dessert_medium_reception_1"));
      receptionDesertMediumModelSpawnWeight =
          builder.comment("Spawn weight for medium models for the desert reception. (0 = disabled)")
              .defineInRange("receptionDesertMediumModelSpawnWeight", 1, 1, 100);
      receptionDesertLargeModel = builder.comment("List of large models for the desert reception.")
          .define("receptionDesertLargeModel",
              List.of("my_personal_apartment:reception/dessert/dessert_large_reception_1"));
      receptionDesertLargeModelSpawnWeight =
          builder.comment("Spawn weight for large models for the desert reception. (0 = disabled)")
              .defineInRange("receptionDesertLargeModelSpawnWeight", 1, 1, 100);
      receptionDesertInfoModel = builder.comment("List of info models for the desert reception.")
          .define("receptionDesertInfoModel",
              List.of("my_personal_apartment:reception/desert/desert_info_stand_1"));
      receptionDesertInfoModelSpawnWeight =
          builder.comment("Spawn weight for info models for the desert reception. (0 = disabled)")
              .defineInRange("receptionDesertInfoModelSpawnWeight", 1, 1, 100);
      builder.pop();

      builder.push("Reception (Plains)");
      receptionPlainsEnabled = builder.comment("Enables the plains reception structures.")
          .define("receptionPlainsEnabled", true);
      receptionPlainsSmallModel = builder.comment("List of small models for the plains reception.")
          .define("receptionPlainsSmallModel",
              List.of("my_personal_apartment:reception/plains/plains_small_reception_1"));
      receptionPlainsSmallModelSpawnWeight =
          builder.comment("Spawn weight for small models for the plains reception. (0 = disabled)")
              .defineInRange("receptionPlainsSmallModelSpawnWeight", 2, 1, 100);
      receptionPlainsMediumModel =
          builder.comment("List of medium models for the plains reception.").define(
              "receptionPlainsMediumModel",
              List.of("my_personal_apartment:reception/plains/plains_medium_reception_1"));
      receptionPlainsMediumModelSpawnWeight =
          builder.comment("Spawn weight for medium models for the plains reception. (0 = disabled)")
              .defineInRange("receptionPlainsMediumModelSpawnWeight", 1, 1, 100);
      receptionPlainsLargeModel = builder.comment("List of large models for the plains reception.")
          .define("receptionPlainsLargeModel",
              List.of("my_personal_apartment:reception/plains/plains_large_reception_1"));
      receptionPlainsLargeModelSpawnWeight =
          builder.comment("Spawn weight for large models for the plains reception. (0 = disabled)")
              .defineInRange("receptionPlainsLargeModelSpawnWeight", 1, 1, 100);
      receptionPlainsInfoModel = builder.comment("List of info models for the plains reception.")
          .define("receptionPlainsInfoModel",
              List.of("my_personal_apartment:reception/plains/plains_info_stand_1"));
      receptionPlainsInfoModelSpawnWeight =
          builder.comment("Spawn weight for info models for the plains reception. (0 = disabled)")
              .defineInRange("receptionPlainsInfoModelSpawnWeight", 1, 1, 100);
      builder.pop();

      builder.push("Reception (Savanna)");
      receptionSavannaEnabled = builder.comment("Enables the savanna reception structures.")
          .define("receptionSavannaEnabled", true);
      receptionSavannaSmallModel =
          builder.comment("List of small models for the savanna reception.").define(
              "receptionSavannaSmallModel",
              List.of("my_personal_apartment:reception/savanna/savanna_small_reception_1"));
      receptionSavannaSmallModelSpawnWeight =
          builder.comment("Spawn weight for small models for the savanna reception. (0 = disabled)")
              .defineInRange("receptionSavannaSmallModelSpawnWeight", 2, 1, 100);
      receptionSavannaMediumModel =
          builder.comment("List of medium models for the savanna reception.").define(
              "receptionSavannaMediumModel",
              List.of("my_personal_apartment:reception/savanna/savanna_medium_reception_1"));
      receptionSavannaMediumModelSpawnWeight = builder
          .comment("Spawn weight for medium models for the savanna reception. (0 = disabled)")
          .defineInRange("receptionSavannaMediumModelSpawnWeight", 1, 1, 100);
      receptionSavannaLargeModel =
          builder.comment("List of large models for the savanna reception.").define(
              "receptionSavannaLargeModel",
              List.of("my_personal_apartment:reception/savanna/savanna_large_reception_1"));
      receptionSavannaLargeModelSpawnWeight =
          builder.comment("Spawn weight for large models for the savanna reception. (0 = disabled)")
              .defineInRange("receptionSavannaLargeModelSpawnWeight", 1, 1, 100);
      receptionSavannaInfoModel = builder.comment("List of info models for the savanna reception.")
          .define("receptionSavannaInfoModel",
              List.of("my_personal_apartment:reception/savanna/savanna_info_stand_1"));
      receptionSavannaInfoModelSpawnWeight =
          builder.comment("Spawn weight for info models for the savanna reception. (0 = disabled)")
              .defineInRange("receptionSavannaInfoModelSpawnWeight", 1, 1, 100);
      builder.pop();

      builder.push("Reception (Taiga)");
      receptionTaigaEnabled = builder.comment("Enables the taiga reception structures.")
          .define("receptionTaigaEnabled", true);
      receptionTaigaSmallModel = builder.comment("List of small models for the taiga reception.")
          .define("receptionTaigaSmallModel",
              List.of("my_personal_apartment:reception/taiga/taiga_small_reception_1"));
      receptionTaigaSmallModelSpawnWeight =
          builder.comment("Spawn weight for small models for the taiga reception. (0 = disabled)")
              .defineInRange("receptionTaigaSmallModelSpawnWeight", 2, 1, 100);
      receptionTaigaMediumModel = builder.comment("List of medium models for the taiga reception.")
          .define("receptionTaigaMediumModel",
              List.of("my_personal_apartment:reception/taiga/taiga_medium_reception_1"));
      receptionTaigaMediumModelSpawnWeight =
          builder.comment("Spawn weight for medium models for the taiga reception. (0 = disabled)")
              .defineInRange("receptionTaigaMediumModelSpawnWeight", 1, 1, 100);
      receptionTaigaLargeModel = builder.comment("List of large models for the taiga reception.")
          .define("receptionTaigaLargeModel",
              List.of("my_personal_apartment:reception/taiga/taiga_large_reception_1"));
      receptionTaigaLargeModelSpawnWeight =
          builder.comment("Spawn weight for large models for the taiga reception. (0 = disabled)")
              .defineInRange("receptionTaigaLargeModelSpawnWeight", 1, 1, 100);
      receptionTaigaInfoModel = builder.comment("List of info models for the taiga reception.")
          .define("receptionTaigaInfoModel",
              List.of("my_personal_apartment:reception/taiga/taiga_info_stand_1"));
      receptionTaigaInfoModelSpawnWeight =
          builder.comment("Spawn weight for info models for the taiga reception. (0 = disabled)")
              .defineInRange("receptionTaigaInfoModelSpawnWeight", 1, 1, 100);
      builder.pop();

      builder.push("Reception (Snowy)");
      receptionSnowyEnabled = builder.comment("Enables the snowy reception structures.")
          .define("receptionSnowyEnabled", true);
      receptionSnowySmallModel = builder.comment("List of small models for the snowy reception.")
          .define("receptionSnowySmallModel",
              List.of("my_personal_apartment:reception/snowy/snowy_small_reception_1"));
      receptionSnowySmallModelSpawnWeight =
          builder.comment("Spawn weight for small models for the snowy reception. (0 = disabled)")
              .defineInRange("receptionSnowySmallModelSpawnWeight", 2, 1, 100);
      receptionSnowyMediumModel = builder.comment("List of medium models for the snowy reception.")
          .define("receptionSnowyMediumModel",
              List.of("my_personal_apartment:reception/snowy/snowy_medium_reception_1"));
      receptionSnowyMediumModelSpawnWeight =
          builder.comment("Spawn weight for medium models for the snowy reception. (0 = disabled)")
              .defineInRange("receptionSnowyMediumModelSpawnWeight", 1, 1, 100);
      receptionSnowyLargeModel = builder.comment("List of large models for the snowy reception.")
          .define("receptionSnowyLargeModel",
              List.of("my_personal_apartment:reception/snowy/snowy_large_reception_1"));
      receptionSnowyLargeModelSpawnWeight =
          builder.comment("Spawn weight for large models for the snowy reception. (0 = disabled)")
              .defineInRange("receptionSnowyLargeModelSpawnWeight", 1, 1, 100);
      receptionSnowyInfoModel = builder.comment("List of info models for the snowy reception.")
          .define("receptionSnowyInfoModel",
              List.of("my_personal_apartment:reception/snowy/snowy_info_stand_1"));
      receptionSnowyInfoModelSpawnWeight =
          builder.comment("Spawn weight for info models for the snowy reception. (0 = disabled)")
              .defineInRange("receptionSnowyInfoModelSpawnWeight", 1, 1, 100);
      builder.pop();
    }
  }

}
