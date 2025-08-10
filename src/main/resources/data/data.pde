String[] colours =  {"white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink"};
String[] specials = {"copper", "exposed_copper", "weathered_copper", "oxidized_copper", "waxed_copper", "waxed_exposed_copper", "waxed_weathered_copper", "waxed_oxidized_copper", "fatal", "nihilo"};
String[] igredients = {"copper_ingot", "",       "",                 "",                "honeycomb",    "honeycomb",            "honeycomb",              "honeycomb", "wither_skeleton_skull", "end_stone"};

void start() {
  String[] lootTable = loadStrings("../diy-die/loot_table/blocks/d6.json");
  String[] recipe = loadStrings("../diy-die/recipe/fatal_d6.json");
  String[] advancement = loadStrings("../diy-die/advancement/recipes/redstone/dye_red_d6.json");
  for (String colour : colours) {
    String[] lCopy = new String[lootTable.length];
    for (int i = 0; i < lootTable.length; i++) {
      lCopy[i] = lootTable[i].replace("d6", colour + "_d6");
    }
    String[] rCopy = new String[recipe.length];
    for (int i = 0; i < recipe.length; i++) {
      rCopy[i] = recipe[i]
        .replace("wither_skeleton_skull", colour + "_dye")
        .replace("fatal_d6", colour + "_d6");
    }
    String[] aCopy = new String[advancement.length];
    for (int i = 0; i < advancement.length; i++) {
      aCopy[i] = advancement[i].replace("red", colour);
    }
    saveStrings("diy-die/loot_table/blocks/" + colour + "_d6.json", lCopy);
    saveStrings("diy-die/recipe/" + colour + "_d6.json", rCopy);
    saveStrings("diy-die/advancement/recipes/redstone/dye_" + colour + "_d6.json", aCopy);
    println("    \"diy-die:" + colour + "_d6\",");
  }
  for (int s = 0; s < specials.length; s++) {
    String[] lCopy = new String[lootTable.length];
    for (int i = 0; i < lootTable.length; i++) {
      lCopy[i] = lootTable[i].replace("d6", specials[s] + "_d6");
    }
    String[] rCopy = new String[recipe.length];
    for (int i = 0; i < recipe.length; i++) {
      rCopy[i] = recipe[i]
        .replace("wither_skeleton_skull", igredients[s])
        .replace("fatal_d6", specials[s] + "_d6")
        .replace("#diy-die:simple_dice", igredients[s].equals("honeycomb") ? "diy-die:" + specials[s].replace("waxed_", "") + "_d6" : "#diy-die:simple_dice");
    }
    String[] aCopy = new String[advancement.length];
    for (int i = 0; i < advancement.length; i++) {
      aCopy[i] = advancement[i].replace("red_dye", igredients[s]).replace("red_d6", specials[s] + "_d6").replace("needed_dye", igredients[s]);
    }
    saveStrings("diy-die/loot_table/blocks/" + specials[s] + "_d6.json", lCopy);
    if (!igredients[s].equals("")) saveStrings("diy-die/recipe/" + specials[s] + "_d6.json", rCopy);
    if (!igredients[s].equals("")) saveStrings("diy-die/advancement/recipes/redstone/" + specials[s] + "_d6.json", aCopy);
  }
  exit();
}
