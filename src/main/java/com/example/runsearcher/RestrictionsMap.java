package com.example.runsearcher;

import java.util.HashMap;

public class RestrictionsMap {
    private HashMap<String, String> restrictions;


    public RestrictionsMap() {
        this.restrictions = new HashMap<>();

    }
    public String getValue(String key) {
        return restrictions.get(key);
    }

    public void populateHashMap() {
        restrictions.put("SL1", "(soul level 1|sl1)");
        restrictions.put("BL4", "(blood level 4|bl4)");
        restrictions.put("No Damage", "(no dmg|no damage|damageless)");
        restrictions.put("No Upgrades", "(no upgrades|no upgrades/infusions|\\+0|no weapon upgrades)");
        restrictions.put("Sorcery Only", "(sorcery only|sorceries only)");
        restrictions.put("No Magic", "(no magic|no sorcery)");
        restrictions.put("NG\\+", "(ng+|new game+|new game plus|new game \\+");
        restrictions.put("No Roll", "(no roll|no dodge|dodgeless|no roll/quickstep)");
        restrictions.put("Pyro Only", "(pyro only|pyromancy only|pyromancies only)");
        restrictions.put("Miracle Only", "(miracle only|miracles only)");
        restrictions.put("Hex Only", "(hex only|hexes only)");
        restrictions.put("NG+6", "(ng\\+6|new game \\+6|new game\\+6)");
        restrictions.put("No Buffs", "(no buffs|buffless|no pellets|no papers)");
        restrictions.put("Arcane Only", "arcane only");
        restrictions.put("No Gems", "no gems");
        restrictions.put("No Hunter's Dream", "(nhd|no hunters dream|no hunter dream|no hunter's dream)");
        restrictions.put("AP1", "(ap1|attack power 1|no upgrades|no damage upgrades|base ap|base attack power)");
        restrictions.put("DB/NKC", "(demon bell|charmless|db/nkc|NKC + DB|DB \\+ NKC|demon bell \\+ charmless|db|nkc|no kuro's charm|demon's bell)");
        restrictions.put("Sword Only", "(sword only|katana only)");
        restrictions.put("Sword DMG Only", "(sword dmg only|katana dmg only)");
        restrictions.put("No Skills", "no skills");
        restrictions.put("No Deflect", "(no deflect|no parry|no parries|no deflects)");
        restrictions.put("No Prosthetics", "no prosthetics");
        restrictions.put("RL1", "(rune level 1|base level|wretch|rl1)");
        restrictions.put("Incantations Only", "(incant only|incants only|incantation only|incantations only)");
        restrictions.put("Regionlocked", "(regionlock|regionlocked|region lock|region locked)");
        restrictions.put("No Triple Mask", "(no triplemask|no triple mask)");



    }
}
