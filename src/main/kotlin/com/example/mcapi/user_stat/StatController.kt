package com.example.mcapi.user_stat

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class StatRequest(val uuid: String, val stat: String, val amount: Int)
//힘 : STR / 지혜 : WIS / 오감 : SEN / 체력 : VIT / 지구력 : END / 정신력 : MND
@RestController
@RequestMapping("/api/stat")
@CrossOrigin("38291") //공유될 포트나 도메인 주소, 즉 *이면 아무나 상관없음, 특정포트를 쓰면 됨
class StatController(private val repo: StatRepository) {

//    @GetMapping("/{uuid}")
//    fun getStat(@PathVariable uuid: String, @RequestBody request: StatRequest): ResponseEntity<StatValueResponse> {
//        val stat = repo.findById(uuid).orElseGet {
//            val newStat = Stat(uuid, 0, 0, 0, 0, 0, 0, 0)
//            repo.save(newStat)
//        }
//
//        val result = when (request.stat) {
//            "힘" -> stat.STR
//            "지혜" -> stat.WIS
//            "오감" -> stat.SEN
//            "체력" -> stat.VIT
//            "지구력" -> stat.END
//            "정신력" -> stat.MND
//            else -> return ResponseEntity.badRequest().build()
//        }
//        return ResponseEntity.ok(StatValueResponse(result))
//    }
        @GetMapping("/{uuid}")
        fun getStat(
            @PathVariable uuid: String,
            @RequestParam stat: String
        ): ResponseEntity<StatValueResponse> {
            val userStat = repo.findById(uuid).orElseGet {
                val newStat = Stat(uuid, 0, 0, 0, 0, 0, 0, 0)
                repo.save(newStat)
            }

            val result = when (stat) {
                "힘" -> userStat.STR
                "지혜" -> userStat.WIS
                "오감" -> userStat.SEN
                "체력" -> userStat.VIT
                "지구력" -> userStat.END
                "정신력" -> userStat.MND
                "스텟" -> userStat.Stat
                else -> return ResponseEntity.badRequest().build()
            }
            println("코드가 정상적으로 실행되었습니다.")
            return ResponseEntity.ok(StatValueResponse(result))
        }

    @PostMapping("/add")
    fun addStat(@RequestBody request: StatRequest): ResponseEntity<Stat> {
        println("코드를 불러왔습니다.")
        val stat = repo.findById(request.uuid).orElse(Stat(request.uuid, 0, 0, 0, 0, 0, 0, 0))
        println("🟢 [addStat] uuid=${request.uuid}, stat=${request.stat}, amount=${request.amount}")
        if(request.stat == "스텟"){ stat.Stat += request.amount }
        else if(request.stat == "힘"){ stat.STR += request.amount }
        else if(request.stat == "지혜"){ stat.WIS += request.amount }
        else if(request.stat == "오감"){ stat.SEN += request.amount }
        else if(request.stat == "체력"){ stat.VIT += request.amount }
        else if(request.stat == "지구력"){ stat.END += request.amount }
        else if(request.stat == "정신력"){ stat.MND += request.amount }
        return ResponseEntity.ok(repo.save(stat))
    }

    @PostMapping("/decrease")
    fun decreaseStat(@RequestBody request: StatRequest): ResponseEntity<Stat> {
        val stat = repo.findById(request.uuid).orElse(Stat(request.uuid, 0, 0, 0, 0, 0, 0, 0))
        if(request.stat == "스텟"){
            if (stat.Stat < request.amount) {
                stat.Stat = 0
            }else{
                stat.Stat -= request.amount
            }
        }
        else if(request.stat == "힘"){
            if (stat.STR < request.amount) {
                stat.STR = 0
            }else{
                stat.STR -= request.amount
            }
        }
        else if(request.stat == "지혜"){
            if (stat.WIS < request.amount) {
                stat.WIS = 0
            }else{
                stat.WIS -= request.amount
            }
        }
        else if(request.stat == "오감"){
            if (stat.SEN < request.amount) {
                stat.SEN = 0
            }else{
                stat.SEN -= request.amount
            }
        }
        else if(request.stat == "체력"){
            if (stat.VIT < request.amount) {
                stat.VIT = 0
            }else{
                stat.VIT -= request.amount
            }
        }
        else if(request.stat == "지구력"){
            if (stat.END < request.amount) {
                stat.END = 0
            }else{
                stat.END -= request.amount
            }
        }
        else if(request.stat == "정신력"){
            if (stat.MND < request.amount) {
                stat.MND = 0
            }else{
                stat.MND -= request.amount
            }
        }

        return ResponseEntity.ok(repo.save(stat))
    }

    @PostMapping("/set")
    fun setStat(@RequestBody request: StatRequest): ResponseEntity<Stat> {
        val stat = repo.findById(request.uuid).orElse(Stat(request.uuid, 0, 0, 0, 0, 0, 0, 0))
        if(request.stat == "스텟"){ stat.Stat = request.amount }
        else if(request.stat == "힘"){ stat.STR = request.amount }
        else if(request.stat == "지혜"){ stat.WIS = request.amount }
        else if(request.stat == "오감"){ stat.SEN = request.amount }
        else if(request.stat == "체력"){ stat.VIT = request.amount }
        else if(request.stat == "지구력"){ stat.END = request.amount }
        else if(request.stat == "정신력"){ stat.MND = request.amount }
        return ResponseEntity.ok(repo.save(stat))
    }
}
