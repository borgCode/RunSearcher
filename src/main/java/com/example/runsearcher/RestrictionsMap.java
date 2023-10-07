package com.example.runsearcher;

import java.util.HashMap;

public class RestrictionsMap {
    private final HashMap<String, String> restrictions;


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
        restrictions.put("NG+", "(ng\\+|new game+|new game plus|new game \\+)");
        restrictions.put("No Roll", "(no roll|no dodge|dodgeless|no roll/quickstep)");
        restrictions.put("Pyro Only", "(pyro only|pyromancy only|pyromancies only)");
        restrictions.put("Miracles Only", "(miracle only|miracles only)");
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
        restrictions.put("No Crafting", "no crafting");
        restrictions.put("Handgun Only", "(handgun only|hand gun only)");
        restrictions.put("No Item Box", "no item box");
        restrictions.put("100%", "100%");
        restrictions.put("Kill All Enemies", "(kill all|kill all enemies)");
        restrictions.put("Ghost", "ghost");
        restrictions.put("Pacifist", "pacifist");
        restrictions.put("Knife Only", "(knife only|only knife)");
        restrictions.put("No Gear", "no gear");
        restrictions.put("No Knockout", "no knockout");
        restrictions.put("Master Mode", "master mode");
        restrictions.put("Bow Only", "(bow only|only bow)");
        restrictions.put("Master Sword", "master sword");
        restrictions.put("Night Only", "(only night|night only)");
        restrictions.put("No Boons", "no boons");
        restrictions.put("No Dash", "(no dashes|no dash|dashless)");
        restrictions.put("Dash Only", "(only dash|dash only)");
        restrictions.put("No Nyx's mirror", "(no nyx mirror|no nyxs mirror)");
        restrictions.put("Cast Only", "(only cast|cast only)");
        restrictions.put("No Choice", "no choice");
        restrictions.put("No Companion", "no companion");
        restrictions.put("Nail Only", "(only nail|nail only)");
        restrictions.put("Skipless", "(no skip|no skips|skipless|skip less)");
        restrictions.put("Melee Only", "(melee only|only melee)");
        restrictions.put("Charmless", "(charmless|no charms|no charm)");
        restrictions.put("No Super Arts", "no super arts");
        restrictions.put("All Phases", "all phases");
        restrictions.put("All Secret Phases", "all secret phases");
        restrictions.put("All King Dice Bosses", "(all king dice bosses|all king dice minibosses|all king dice mini bosses)");
        restrictions.put("Twin Heart", "twin heart");
        restrictions.put("All S Ranks", "(all perfect grades|perfect grades|all s ranks|all s rank|s rank|s ranks)");
    }
}
