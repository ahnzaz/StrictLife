package com.devworm.android.strictlife.module.storage;

import com.devworm.android.strictlife.module.AbstractModule;

/**
 * Storage module factory. <br />
 * @since 1.0
 * @created 2015-10-07
 */
public abstract class StorageModuleImpl extends AbstractModule implements StorageModule {
    public static final int NATIVE_STORAGE = 1;
    public static final int SQLITEDB_STORAGE = 2;

    public static final int DEFAULT_STORAGE_SOURCE = NATIVE_STORAGE;

    private static final StorageModule instance;

    static {
        switch (DEFAULT_STORAGE_SOURCE) {
            case NATIVE_STORAGE: {
                instance = new NativeStorageModuleImpl();
                break;
            }

            case SQLITEDB_STORAGE :{
                instance = null;
                break;
            }
            default: {
                instance = new NativeStorageModuleImpl();
            }
        }
    }

    public static StorageModule getInstance() {
        return instance;
    }
}
