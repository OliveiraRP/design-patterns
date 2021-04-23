package com.es2.memento;

import java.util.ArrayList;

public class BackupService {

    Server backup;
    private ArrayList<Memento> mementos;

    public BackupService(Server server) {

        backup = server;
        mementos = new ArrayList<>();
    }

    public void takeSnapshot() {

        Memento m = backup.backup();
        mementos.add(m);
    }

    public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException {
        if(snapshotNumber >= 0 && snapshotNumber < mementos.size())
            backup.restore(mementos.get(snapshotNumber));
        else
            throw new NotExistingSnapshotException();
    }
}
