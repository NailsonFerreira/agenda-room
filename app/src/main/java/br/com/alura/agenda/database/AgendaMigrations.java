package br.com.alura.agenda.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

public class AgendaMigrations {

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE aluno ADD COLUMN sobrenome TEXT");
        }
    };
    public static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE aluno ADD COLUMN momentoCadastro INTEGER");
        }
    };
    public static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE aluno ADD COLUMN telefoneFixo TEXT");
            database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_novo` " +
                    "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`nome` TEXT, " +
                    "`sobrenome` TEXT, " +
                    "`telefoneCelular` TEXT, " +
                    "`telefoneFixo` TEXT, " +
                    "`email` TEXT, " +
                    "`momentoCadastro` INTEGER)");

            database.execSQL("INSERT INTO Aluno_novo(id, nome, sobrenome, telefoneCelular, email, momentocadastro) " +
                    "SELECT id, nome, sobrenome, telefone, email, momentoCadastro FROM aluno");

            database.execSQL("DROP TABLE aluno");

            database.execSQL("ALTER TABLE Aluno_novo RENAME TO Aluno");

        }
    };
    public static final Migration[] MIGRATIONS = {MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4};
}
