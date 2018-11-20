package com.ravenshell.peerstream.wificonnector;

import android.content.Context;
import android.net.wifi.ScanResult;

import com.ravenshell.peerstream.wificonnector.scanner.Scanner;
import com.ravenshell.peerstream.wificonnector.scanner.WifiScanner;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by ogie on 11/19/2018.
 */
public class WifiScannerTest {

    @Mock
    Context context;

    private WifiScanner mWifiScanner;

    @Captor
    ArgumentCaptor<Scanner.Callback> mScannerCallback;

    @Before
    public void setUp() throws Exception {
         MockitoAnnotations.initMocks(this);
         mWifiScanner = new WifiScanner(context);

        //wifiScanner.setupWifiManager();
    }

    @Test
    public void beginSearch() throws Exception {

        mWifiScanner.setupWifiManager(mScannerCallback.capture());
        List<ScanResult> result =  mWifiScanner.getDevices();

        assertNotNull("Scan Result cannot be null", result);
    }

    @Test
    public void stopSearch() throws Exception {
    }

}