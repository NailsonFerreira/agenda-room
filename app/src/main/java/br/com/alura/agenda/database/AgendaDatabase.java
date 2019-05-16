package br.com.alura.agenda.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import br.com.alura.agenda.database.converter.CoversorCalendar;
import br.com.alura.agenda.database.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

import static br.com.alura.agenda.database.AgendaMigrations.MIGRATIONS;

@Database(entities = {Aluno.class}, version = 4, exportSchema = false)
@TypeConverters({CoversorCalendar.class})
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String AGENDA_DB = "agenda.db";


    public abstract AlunoDAO getRoomAlunoDAO();

    public static AgendaDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, AgendaDatabase.class, AGENDA_DB)
                .allowMainThreadQueries()
                .addMigrations(MIGRATIONS)
                .build();
    }
}
