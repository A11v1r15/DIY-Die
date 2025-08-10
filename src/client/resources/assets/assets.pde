String[] colours =  {"white", "light_gray", "gray",  "black", "brown", "red",   "orange", "yellow", "lime",  "green", "cyan",  "light_blue", "blue",  "purple", "magenta", "pink",  "copper", "exposed_copper", "weathered_copper", "oxidized_copper", "waxed_copper", "waxed_exposed_copper", "waxed_weathered_copper", "waxed_oxidized_copper", "fatal", "nihilo"};
String[] colours2 = {"black", "black",      "black", "white", "white", "white", "black",  "black",  "black", "white", "black", "black",      "white", "white",  "white",   "black", "black",  "black",          "black",            "black",           "black",        "black",                "black",                  "black",                 "red",   "red"};

void start() {
  String[] blockstates = loadStrings("../diy-die/blockstates/d6.json");
  String[] items = loadStrings("../diy-die/items/d6.json");
  for (String colour : colours) {
    String[] bCopy = new String[blockstates.length];
    String[] iCopy = new String[items.length];
    for (int i = 0; i < blockstates.length; i++) {
      bCopy[i] = blockstates[i].replace("d6", colour + "_d6");
    }
    for (int i = 0; i < items.length; i++) {
      iCopy[i] = items[i].replace("d6", colour + "_d6");
    }
    saveStrings("diy-die/blockstates/" + colour + "_d6.json", bCopy);
    saveStrings("diy-die/items/" + colour + "_d6.json", iCopy);
    println("  \"block.diy-die." + colour + "_d6\": \"" + format(colour) + " D6 Block\",\n  \"item.diy-die." + colour + "_d6\": \"" + format(colour) + " D6\",");
  }
  for (int j = 1; j <= 6; j++) {
    String[] models = loadStrings("../diy-die/models/block/fatal_d6_" + j + ".json");
    for (int c = 0; c < colours.length; c++) {
      String[] mCopy = new String[models.length];
      for (int i = 0; i < models.length; i++) {
        mCopy[i] = models[i].replace("fatal_d6", colours[c].replace("waxed_", "") + "_d6").replace("red_dots", colours2[c] + "_dots");
      }
      saveStrings("diy-die/models/block/" + colours[c] + "_d6_" + j + ".json", mCopy);
    }
  }
  exit();
}

String format(String input){
  String output = input.replace("_", " ");
  output = output.substring(0, 1).toUpperCase() + output.substring(1);
  return output;
}
