package service

import enum.SkillType
import model.Skill
import org.springframework.stereotype.Service

/**
 * Created by xhan91 on 2017-06-18.
 */
@Service
class SkillService {

    val skill1 = Skill(1, SkillType.F) { _, _, game -> {
        game.skillChain.removeLast()
    } }

    val skill2 = Skill(2, SkillType.D) { myself, enemy, _ -> {
        myself.takeDamage(true, 1)
        enemy.takeDamage(false, 3)
    } }
}