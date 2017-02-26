//
//  DataViewController.swift
//  AAAA
//
//  Created by Hong Nhung on 2/18/17.
//  Copyright © 2017 Hong Nhung. All rights reserved.
//

import UIKit

class DataViewController: UIViewController {

    @IBOutlet weak var dataLabel: UILabel!
    var dataObject: String = ""

    @IBOutlet weak var btnA: UIButton!

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        self.dataLabel!.text = dataObject
    }

    @IBAction func pressBtnA(_ sender: Any) {
        print("AAAAAAA");
        
        let storyboard = UIStoryboard.init(name:"Main", bundle: nil);
        let vc = storyboard.instantiateViewController(withIdentifier:"AAA");
        
        self.present(vc, animated:true, completion: nil);
    }
}

