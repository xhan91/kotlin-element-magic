package model

import enum.SkillType

/**
 * Created by xhan91 on 2017-06-16.
 */
class Skill(private val value: Int,
            private val type: SkillType,
            private val apply: (Player, Player, Game) -> Unit) {

}