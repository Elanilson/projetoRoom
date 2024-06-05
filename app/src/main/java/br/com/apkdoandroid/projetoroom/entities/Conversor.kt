package br.com.apkdoandroid.projetoroom.entities

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import java.util.Date

@ProvidedTypeConverter
class Conversor {

    @TypeConverter
    fun converterParaLong(data : Date?) : Long?{
        return data?.time
    }
    @TypeConverter
    fun converterParaDate(data : Long?) : Date?{
        return data?.let { dtLong ->
            Date(dtLong)
        }
    }
}