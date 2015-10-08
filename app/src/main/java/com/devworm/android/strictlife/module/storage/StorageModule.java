package com.devworm.android.strictlife.module.storage;

import com.devworm.android.strictlife.module.Module;

/**
 * Interface for storage module. <br />
 * @since 1.0
 * @created 2015-10-07
 */
public interface StorageModule extends Module {
    void saveData(String src, String tag, String data, StorageCallback function);
    void saveData(Class<?> src, String tag, String data, StorageCallback function);
    void saveData(String src, String tag, byte[] data, StorageCallback function);
    void saveData(Class<?> src, String tag, byte[] data, StorageCallback function);
}
