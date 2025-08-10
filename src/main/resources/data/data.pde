String[] colours =  {"white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "fatal", "nihilo"};

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
  exit();
}
